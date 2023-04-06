package controllers.admin;

import DomainModel.ChucVu;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChucVuRepository;
import repositories.MauSacRepository;
import view_model.QLCuaHang;
import view_model.QLMauSac;
import view_model.QlChucVu;

import java.io.IOException;

@WebServlet({
        "/chuc_vu/index",
        "/chuc_vu/create",
        "/chuc_vu/store",
        "/chuc_vu/edit",
        "/chuc_vu/update",
        "/chuc_vu/delete",
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository msRepo;
    public ChucVuServlet(){
        this.msRepo = new ChucVuRepository();
    }
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);
        } else if (uri.contains("edit")) {
            this.edit(request,response);
        }else if (uri.contains("delete")) {
            this.delete(request,response);
        }else{
            this.index(request,response);
        }
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/chuc_vu/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach",this.msRepo.findALl());
        request.setAttribute("view","/views/chuc_vu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cv = this.msRepo.findByMa(ma);
        if (cv== null){
            System.out.println("không tìm thấy");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else {
            this.msRepo.delete(cv);
            response.sendRedirect("/demoTest_war_exploded/chuc_vu/index");
        }
    } protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu qlkh = this.msRepo.findByMa(ma);
        request.setAttribute("ms",qlkh);
        this.msRepo.update(qlkh);
        request.setAttribute("view","/views/chuc_vu/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request,response);
        }else if(uri.contains("update")) {
            this.update(request, response);
        }else {
            response.sendRedirect("/demoTest_war_exploded/chuc_vu/index");
        }

    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        ChucVu qlkh = new ChucVu();
        try {
            BeanUtils.populate(qlkh,request.getParameterMap());
            this.msRepo.insert(qlkh);
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu qlkh = this.msRepo.findByMa(ma);
        try {
            BeanUtils.populate(qlkh,request.getParameterMap());
            this.msRepo.update(qlkh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demoTest_war_exploded/chuc_vu/index");
        System.out.println("update thành công");
    }
}

