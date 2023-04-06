package repositories;

import DomainModel.CuaHang;
import DomainModel.KhachHang;
import DomainModel.NhanVien;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    private Session hSession;
    public CuaHangRepository(){

        this.hSession = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(CuaHang kh){

        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(kh);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void update(CuaHang kh){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(kh);
            this.hSession.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public List<CuaHang> findALl(){
        String hql = "SELECT khObj FROM CuaHang khObj";
        TypedQuery<CuaHang> query = this.hSession.createQuery(hql,CuaHang.class);
        return query.getResultList();
    }
    public CuaHang findByMa(String ma){
        String hql = "SELECT khObj FROM CuaHang khObj WHERE khObj.Ma = ?1";
        TypedQuery<CuaHang> query = this.hSession.createQuery(hql,CuaHang.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
    public void delete(CuaHang kh){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(kh);
            this.hSession.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public CuaHang findById(UUID Id)
    {
        return this.hSession.find(CuaHang.class, Id);
    }
}
