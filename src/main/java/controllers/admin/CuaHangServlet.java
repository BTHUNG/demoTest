package controllers.admin;

import DomainModel.CuaHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.CuaHangRepository;

import java.io.IOException;


@WebServlet({"/Cua_hang/index",
        "/Cua_hang/create",
        "/Cua_hang/store",
        "/Cua_hang/edit",
        "/Cua_hang/update",
        "/Cua_hang/delete",})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository chRepo;
    public CuaHangServlet(){
        this.chRepo = new CuaHangRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = request.getRequestURI();
       if (url.contains("create")){
            this.create(request,response);
        }else if (url.contains("edit")) {
            this.edit(request,response);
        }else if (url.contains("delete")) {
            this.delete(request,response);
        }else {
            this.index(request,response);
        }

    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("view","/views/Cua_hang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void index(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("danhSach",this.chRepo.findALl());
        request.setAttribute("view","/views/Cua_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);

    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang qlCH = this.chRepo.findByMa(ma);
        if (qlCH== null){
            System.out.println("không tìm thấy");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else {
            this.chRepo.delete(qlCH);
            response.sendRedirect("/demoTest_war_exploded/Cua_hang/index");
        }
    }
    @Override
    protected void doPost(   HttpServletRequest request,
                             HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request,response);
        }else if(uri.contains("update")) {
            this.update(request, response);
        }else {
            response.sendRedirect("/demoTest_war_exploded/Cua_hang/index");
        }
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang qlkh = this.chRepo.findByMa(ma);
        request.setAttribute("ch",qlkh);
        this.chRepo.update(qlkh);
        request.setAttribute("view","/views/Cua_hang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }
    protected void store(HttpServletRequest request,
                         HttpServletResponse response
    ) throws ServletException, IOException {
        CuaHang qlkh = new CuaHang();
        try {
            BeanUtils.populate(qlkh,request.getParameterMap());
            this.chRepo.insert(qlkh);
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang qlkh = this.chRepo.findByMa(ma);
        try {
            BeanUtils.populate(qlkh,request.getParameterMap());
            this.chRepo.update(qlkh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demoTest_war_exploded/Cua_hang/index");
        System.out.println("update thành công");
    }
}
