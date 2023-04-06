package controllers.admin;

import DomainModel.NSX;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.DongSPReponsitory;
import repositories.NSXRepository;
import view_model.QLDongSP;
import view_model.QLNSX;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/NSX/index",
        "/NSX/create",
        "/NSX/store",
        "/NSX/edit",
        "/NSX/update",
        "/NSX/delete",
})
public class NSXServlet extends HttpServlet {
    private NSXRepository msRepo;
    public NSXServlet(){
        this.msRepo = new NSXRepository();
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
        request.setAttribute("view","/views/NSX/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach",this.msRepo.findAll());
        request.setAttribute("view","/views/NSX/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }   protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX nsx = this.msRepo.findByMa(ma);
        if (nsx== null){
            System.out.println("không tìm thấy");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else {
            this.msRepo.delete(nsx);
            response.sendRedirect("/demoTest_war_exploded/NSX/index");
        }
    } protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX nsx = this.msRepo.findByMa(ma);
        request.setAttribute("ms",nsx);
        this.msRepo.update(nsx);
        request.setAttribute("view","/views/NSX/edit.jsp");
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
            response.sendRedirect("/demoTest_war_exploded/NSX/index");
        }

    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        NSX nsx = new NSX();
        try {
            BeanUtils.populate(nsx,request.getParameterMap());
            this.msRepo.insert(nsx);
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX nsx = this.msRepo.findByMa(ma);
        try {
            BeanUtils.populate(nsx,request.getParameterMap());
            this.msRepo.update(nsx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demoTest_war_exploded/NSX/index");
        System.out.println("update thành công");
    }
}
