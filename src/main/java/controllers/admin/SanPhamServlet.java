package controllers.admin;

import DomainModel.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NSXRepository;
import repositories.SanPhamRepository;
import view_model.QLNSX;
import view_model.QLSanPham;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/San_pham/index",
        "/San_pham/create",
        "/San_pham/store",
        "/San_pham/edit",
        "/San_pham/update",
        "/San_pham/delete",
})
public class SanPhamServlet extends HttpServlet {

    private SanPhamRepository spRepo;

    public SanPhamServlet() {
        this.spRepo = new SanPhamRepository();
    }

    ;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("create")) {
            this.create(request, response);
        } else if (url.contains("delete")) {
            this.delete(request, response);
        } else if (url.contains("edit")) {
            this.edit(request, response);
        } else {
            this.index(request, response);
        }
    }

    public void index(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("danhSach", this.spRepo.findAll());
        req.setAttribute("view", "/views/san_pham/index.jsp");
        req.getRequestDispatcher("/views/layout.jsp").forward(req, res);
    }


    public void create(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("view", "/views/san_pham/create.jsp");
        req.getRequestDispatcher("/views/layout.jsp").forward(req, res);
    }


    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        SanPham qlsp = this.spRepo.findByMa(ma);
        if (qlsp == null) {
            System.out.println("Không tìm thấy");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.spRepo.delete(qlsp);
            response.sendRedirect("/demoTest_war_exploded/san-pham/index");
        }
    }


    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/demoTest_war_exploded/san-pham/index");
        }
    }


    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("Ma");
        SanPham qlsp = this.spRepo.findByMa(ma);
        try {
            BeanUtils.populate(qlsp, request.getParameterMap());
            this.spRepo.update(qlsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demoTest_war_exploded/san-pham/index");
    }


    public void edit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String ma = req.getParameter("Ma");
        SanPham qlsp = this.spRepo.findByMa(ma);
        req.setAttribute("sp", qlsp);
        req.setAttribute("view", "/views/san_pham/edit.jsp");
        req.getRequestDispatcher("/views/layout.jsp").forward(req, res);
    }


    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String ma_loi = "", ten_loi = "";
        SanPham qlsp = new SanPham();
        if (ma == null || ma.isEmpty()) {
            ma_loi = "Vui lòng nhập mã";
            request.setAttribute("ma_loi", ma_loi);
            request.setAttribute("view", "/views/san_pham/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        } else if (ten == null || ten.isEmpty()) {
            ten_loi = "Vui lòng nhập tên";
            request.setAttribute("ten_loi", ten_loi);
            request.setAttribute("view", "/views/san_pham/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        } else {
            try {
                BeanUtils.populate(qlsp, request.getParameterMap());
                this.spRepo.insert(qlsp);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Thêm thành công");
            response.sendRedirect("/demoTest_war_exploded/san-pham/index");
        }

    }}

