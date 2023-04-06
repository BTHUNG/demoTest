package controllers.admin;

import DomainModel.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;
import repositories.MauSacRepository;
import view_model.QLKhachHang;
import DomainModel.MauSac;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/Mau_sac/index",
        "/Mau_sac/create",
        "/Mau_sac/store",
        "/Mau_sac/edit",
        "/Mau_sac/update",
        "/Mau_sac/delete",
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository msRepo;
    public MauSacServlet(){
        this.msRepo = new MauSacRepository();
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
        request.setAttribute("view","/views/Mau_sac/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach",this.msRepo.findAll());
        request.setAttribute("view","/views/Mau_sac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }   protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac qlkh = this.msRepo.findByMa(ma);
        if (qlkh== null){
            System.out.println("không tìm thấy");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else {
            this.msRepo.delete(qlkh);
            response.sendRedirect("/demoTest_war_exploded/Mau_sac/index");
        }
    } protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac qlkh = this.msRepo.findByMa(ma);
        request.setAttribute("ms",qlkh);
        this.msRepo.update(qlkh);
        request.setAttribute("view","/views/Mau_sac/edit.jsp");
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
            response.sendRedirect("/demoTest_war_exploded/Mau_sac/index");
        }

    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        MauSac qlkh = new MauSac();
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
        MauSac qlkh = this.msRepo.findByMa(ma);
        try {
            BeanUtils.populate(qlkh,request.getParameterMap());
            this.msRepo.update(qlkh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demoTest_war_exploded/Mau_sac/index");
        System.out.println("update thành công");
    }
}
