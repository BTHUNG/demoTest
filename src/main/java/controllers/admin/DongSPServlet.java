package controllers.admin;

import DomainModel.DongSP;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.DongSPReponsitory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@WebServlet({
        "/Dong_SP/index",
        "/Dong_SP/create",
        "/Dong_SP/store",
        "/Dong_SP/edit",
        "/Dong_SP/update",
        "/Dong_SP/delete",
})
public class DongSPServlet extends HttpServlet {
    private DongSPReponsitory msRepo;
    public DongSPServlet(){
        this.msRepo = new DongSPReponsitory();

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
        request.setAttribute("view","/views/Dong_SP/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach",this.msRepo.findAll());
        request.setAttribute("view","/views/Dong_SP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }   protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP qlkh = this.msRepo.findByMa(ma);
        if (qlkh== null){
            System.out.println("không tìm thấy");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else {
            this.msRepo.delete(qlkh);
            response.sendRedirect("/demoTest_war_exploded/Dong_SP/index");
        }
    } protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP qlkh = this.msRepo.findByMa(ma);
        request.setAttribute("ms",qlkh);
        this.msRepo.update(qlkh);
        request.setAttribute("view","/views/Dong_SP/edit.jsp");
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
            response.sendRedirect("/demoTest_war_exploded/Dong_SP/index");
        }

    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
//        DongSP qlkh = new DongSP(ma, ten);
        String ma_l = "", ten_l = "";
        if (ma == null || ma.isEmpty()) {
            ma_l = "Vui lòng nhập mã";
            request.setAttribute("ma_l", ma_l);
            request.setAttribute("view", "/views/Dong_SP/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
        } else if (ten == null || ten.isEmpty()) {
            ten_l = "Vui lòng nhập tên ";
            request.setAttribute("ten_l", ten_l);
            request.setAttribute("view", "/views/Dong_SP/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp")
                    .forward(request, response);
        } else {
//
//            msRepo.findALl().add(qlkh);
            System.out.println("Thêm thành công");
            response.sendRedirect("/demoTest_war_exploded/Dong_SP/index");
        }
    }
        protected void update(
                HttpServletRequest request,
                HttpServletResponse response
    ) throws ServletException, IOException {
            DongSP qlms = new DongSP();
            try {
                BeanUtils.populate(qlms, request.getParameterMap());
                this.msRepo.update(qlms);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/demoTest_war_exploded/Dong_SP/index");

        }
}