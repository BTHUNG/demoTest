package controllers.admin;
import DomainModel.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;
import view_model.QLDongSP;
import view_model.QLKhachHang;
import view_model.QLSanPham;

import java.io.IOException;

@WebServlet({
        "/khach_hang/index",
        "/khach_hang/create",
        "/khach_hang/store",
        "/khach_hang/edit",
        "/khach_hang/update",
        "/khach_hang/delete",
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository hkRepo;
    public KhachHangServlet(){
        this.hkRepo = new KhachHangRepository();
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
        request.setAttribute("view","/views/khach_hang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
.forward(request, response);
    }    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach",this.hkRepo.findALl());
        request.setAttribute("view","/views/khach_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }   protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
       String ma = request.getParameter("Ma");
       KhachHang khDomain = this.hkRepo.findByMa(ma);
       if (khDomain== null){
           System.out.println("không tìm thấy");
           response.sendError(HttpServletResponse.SC_NOT_FOUND);
       }else {
           this.hkRepo.delete(khDomain);
           response.sendRedirect("/demoTest_war_exploded/khach_hang/index");
       }
    } protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
       String ma = request.getParameter("Ma");
       KhachHang kh = this.hkRepo.findByMa(ma);
       request.setAttribute("kh",kh);
           this.hkRepo.update(kh);
           request.setAttribute("view","/views/khach_hang/edit.jsp");
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
            response.sendRedirect("/demoTest_war_exploded/khach_hang/index");
        }

    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        KhachHang khDomain = new KhachHang();
        try {
            BeanUtils.populate(khDomain,request.getParameterMap());
            this.hkRepo.insert(khDomain);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thêm thành công");
        response.sendRedirect("/demoTest_war_exploded/khach_hang/index");
    }

     protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
String ma = request.getParameter("ma");
        KhachHang khDomain = this.hkRepo.findByMa(ma);
        try {
            BeanUtils.populate(khDomain,request.getParameterMap());
            this.hkRepo.update(khDomain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demoTest_war_exploded/khach_hang/index");
        System.out.println("update thành công");
    }
}


