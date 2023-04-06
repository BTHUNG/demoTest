package controllers.admin;

import DomainModel.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/Chi_tietSP/index",
        "/Chi_tietSP/create",
        "/Chi_tietSP/store",
        "/Chi_tietSP/edit",
        "/Chi_tietSP/update",
        "/Chi_tietSP/delete",
})
public class ChiTietSpServlet extends HttpServlet {
    ChiTietSPRepository ctspRepo = new ChiTietSPRepository();
    MauSacRepository msRepo = new MauSacRepository();
    NSXRepository nsxRepo = new NSXRepository();
    SanPhamRepository spRepo = new SanPhamRepository();
    DongSPReponsitory dspRepo = new DongSPReponsitory();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("create")) {
            this.create(req, res);
        } else if (url.contains("delete")) {
            this.delete(req, res);
        } else if (url.contains("edit")) {
            this.edit(req, res);
        } else {
            this.index(req, res);
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
            response.sendRedirect("/demoTest_war_exploded/Chi_tietSP/index");
        }
    }

    public void index(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<ChiTietSP> ctsp = ctspRepo.findAll();
        List<MauSac> ms = msRepo.findAll();
        List<NSX> nsx = nsxRepo.findAll();
        List<DongSP> dsp = dspRepo.findAll();
        List<SanPham> sp = spRepo.findAll();

        req.setAttribute("sp", sp);
        req.setAttribute("nsx", nsx);
        req.setAttribute("ms", ms);
        req.setAttribute("dsp", dsp);
        req.setAttribute("ctsp", ctsp);

        req.setAttribute("view", "/views/Chi_tietSP/index.jsp");
        req.getRequestDispatcher("/views/layout.jsp").forward(req, res);
    }

    public void create(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<ChiTietSP> ctsp = ctspRepo.findAll();
        List<MauSac> ms = msRepo.findAll();
        List<NSX> nsx = nsxRepo.findAll();
        List<DongSP> dsp = dspRepo.findAll();
        List<SanPham> sp = spRepo.findAll();

        req.setAttribute("sp", sp);
        req.setAttribute("nsx", nsx);
        req.setAttribute("ms", ms);
        req.setAttribute("dsp", dsp);
        req.setAttribute("ctsp", ctsp);
        req.setAttribute("view", "/views/Chi_tietSP/create.jsp");
        req.getRequestDispatcher("/views/layout.jsp").forward(req, res);
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        UUID idSP = UUID.fromString(request.getParameter("idSP"));
        SanPham sanPham = spRepo.findById(idSP);
        UUID idNSX = UUID.fromString(request.getParameter("idNSX"));
        NSX nsx = nsxRepo.findById(idNSX);
        UUID idMS = UUID.fromString(request.getParameter("idMauSac"));
        MauSac mauSac = msRepo.findById(idMS);
        UUID idDSP = UUID.fromString(request.getParameter("idDongSP"));
        DongSP dongSP = dspRepo.findById(idDSP);
        Integer namBH = Integer.parseInt(request.getParameter("namBH"));
        String moTa = request.getParameter("moTa");
        Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
        Double giaNhap = Double.parseDouble(request.getParameter("giaNhap"));
        Double giaBan = Double.parseDouble(request.getParameter("giaBan"));
        ChiTietSP chiTietSP = new ChiTietSP();
        chiTietSP.setSanPham(sanPham);
        chiTietSP.setNsx(nsx);
        chiTietSP.setMauSac(mauSac);
        chiTietSP.setDongSP(dongSP);
        chiTietSP.setNamBH(namBH);
        chiTietSP.setMoTa(moTa);
        chiTietSP.setSoLuongTon(soLuongTon);
        chiTietSP.setGiaNhap(giaNhap);
        chiTietSP.setGiaBan(giaBan);
        ctspRepo.insert(chiTietSP);
        response.sendRedirect("/demoTest_war_exploded/Chi_tietSP/index");
        System.out.println("Thêm thành công");

    }

    public void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        ChiTietSP chiTietSP =ctspRepo.findById(id);
        ctspRepo.delete(chiTietSP);
        res.sendRedirect("/demoTest_war_exploded/Chi_tietSP/index");

    }


    public void update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        UUID idSP = UUID.fromString(req.getParameter("idSP"));
        SanPham sanPham = spRepo.findById(idSP);
        UUID idNSX = UUID.fromString(req.getParameter("idNSX"));
        NSX nsx = nsxRepo.findById(idNSX);
        UUID idMS = UUID.fromString(req.getParameter("idMauSac"));
        MauSac mauSac = msRepo.findById(idMS);
        UUID idDSP = UUID.fromString(req.getParameter("idDongSP"));
        DongSP dongSP = dspRepo.findById(idDSP);
        Integer namBH = Integer.parseInt(req.getParameter("namBH"));
        String moTa = req.getParameter("moTa");
        Integer soLuongTon = Integer.parseInt(req.getParameter("soLuongTon"));
        Double giaNhap = Double.parseDouble(req.getParameter("giaNhap"));
        Double giaBan = Double.parseDouble(req.getParameter("giaBan"));
        ChiTietSP chiTietSP = ctspRepo.findById(id);

        chiTietSP.setSanPham(sanPham);
        chiTietSP.setNsx(nsx);
        chiTietSP.setMauSac(mauSac);
        chiTietSP.setDongSP(dongSP);
        chiTietSP.setNamBH(namBH);
        chiTietSP.setMoTa(moTa);
        chiTietSP.setSoLuongTon(soLuongTon);
        chiTietSP.setGiaNhap(giaNhap);
        chiTietSP.setGiaBan(giaBan);
        ctspRepo.update(chiTietSP);
        res.sendRedirect("/demoTest_war_exploded/Chi_tietSP/index");

    }


    public void edit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        UUID id = UUID.fromString(req.getParameter("id"));
        ChiTietSP chiTietSP =ctspRepo.findById(id);

        List<MauSac> ms = msRepo.findAll();
        List<NSX> nsx = nsxRepo.findAll();
        List<DongSP> dsp = dspRepo.findAll();
        List<SanPham> sp = spRepo.findAll();

        req.setAttribute("sp", sp);
        req.setAttribute("nsx", nsx);
        req.setAttribute("ms", ms);
        req.setAttribute("dsp", dsp);
        req.setAttribute("ctsp", chiTietSP);
        req.setAttribute("view", "/views/Chi_tietSP/edit.jsp");
        req.getRequestDispatcher("/views/layout.jsp").forward(req, res);
    }
}
