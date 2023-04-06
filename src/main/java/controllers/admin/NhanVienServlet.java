package controllers.admin;

import DomainModel.ChucVu;
import DomainModel.CuaHang;
import DomainModel.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChucVuRepository;
import repositories.CuaHangRepository;
import repositories.NhanVienRepository;
import view_model.QLNhanVien;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;


@WebServlet({
        "/Nhan_vien/index",
        "/Nhan_vien/create",
        "/Nhan_vien/store",
        "/Nhan_vien/edit",
        "/Nhan_vien/update",
        "/Nhan_vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nvRepo;
    private ChucVuRepository cvRepo;
    private CuaHangRepository chRepo;

    public NhanVienServlet() {
        this.nvRepo = new NhanVienRepository();
        this.cvRepo = new ChucVuRepository();
        this.chRepo = new CuaHangRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }

    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("listChucVu",this.cvRepo.findALl());
        request.setAttribute("view","/views/Nhan_vien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);

    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("danhSach", this.nvRepo.findALl());
        request.setAttribute("view", "/views/Nhan_vien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = this.nvRepo.findByMa(ma);
        try {
            BeanUtils.populate(nv,request.getParameterMap());
            this.nvRepo.update(nv);
            System.out.println("update Oke");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("update Oke");
            response.sendRedirect("/demoTest_war_exploded/Nhan_vien/index");

    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien qlnv = this.nvRepo.findByMa(ma);
        if (qlnv == null) {
            System.out.println("không tìm thấy");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.nvRepo.detele(qlnv);
            response.sendRedirect("/demoTest_war_exploded/Nhan_vien/index");
        }

    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien qlkh = this.nvRepo.findByMa(ma);
        request.setAttribute("nv", qlkh);
        this.nvRepo.update(qlkh);
        request.setAttribute("listChucVu",this.cvRepo.findALl());
        request.setAttribute("view", "/views/Nhan_vien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request,response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/demoTest_war_exploded/Nhan_vien/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        NhanVien nv = new NhanVien();
        ChucVu cv = new ChucVu();
        CuaHang ch = new CuaHang();
       try {
           BeanUtils.populate(nv,request.getParameterMap());
//           cv = this.cvRepo.findById(UUID.fromString(request.getParameter("IdCV")));
//           System.out.println(cv.);
//           ch = this.chRepo.findById(UUID.fromString(request.getParameter("IdCH")));
//           nv.setCv(cv);
//           nv.setCh(ch);
           this.nvRepo.insert(nv);
       }catch (Exception e){
           e.printStackTrace();
       }
        System.out.println("Them oke");
        response.sendRedirect("/demoTest_war_exploded/Nhan_vien/index");
    }

}
