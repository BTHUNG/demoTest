package DomainModel;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id ;

    @Column(name="IdKH")
    private String IdKH ;

    @OneToMany(mappedBy = "hd")
    private List<NhanVien> listNV;

    @Column(name="IdNV")
    private String IdNV ;

    @Column(name="Ma")
    private String Ma ;

    @Column(name="NgayTao")
    private Date NgayTao ;

    @Column(name="NgayThanhToan")
    private Date NgayThanhToan ;

    @Column(name="NgayShip")
    private Date NgayShip ;

    @Column(name="NgayNhan")
    private Date NgayNhan ;

    @Column(name="TinhTrang")
    private String TinhTrang ;

    @Column(name="TenNguoiNhan")
    private String TenNguoiNhan ;

    @Column(name="DiaChi")
    private String DiaChi ;

    @Column(name="Sdt")
    private String Sdt ;

    public HoaDon() {
    }

    public HoaDon(String id, String idKH, String idNV, String ma, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, String tinhTrang, String tenNguoiNhan, String diaChi, String sdt) {
        Id = id;
        IdKH = idKH;
        IdNV = idNV;
        Ma = ma;
        NgayTao = ngayTao;
        NgayThanhToan = ngayThanhToan;
        NgayShip = ngayShip;
        NgayNhan = ngayNhan;
        TinhTrang = tinhTrang;
        TenNguoiNhan = tenNguoiNhan;
        DiaChi = diaChi;
        Sdt = sdt;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIdKH() {
        return IdKH;
    }

    public void setIdKH(String idKH) {
        IdKH = idKH;
    }

    public String getIdNV() {
        return IdNV;
    }

    public void setIdNV(String idNV) {
        IdNV = idNV;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date ngayTao) {
        NgayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        NgayThanhToan = ngayThanhToan;
    }

    public Date getNgayShip() {
        return NgayShip;
    }

    public void setNgayShip(Date ngayShip) {
        NgayShip = ngayShip;
    }

    public Date getNgayNhan() {
        return NgayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        NgayNhan = ngayNhan;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public String getTenNguoiNhan() {
        return TenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        TenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }
}
