package repositories;

import DomainModel.NSX;
import DomainModel.NhanVien;
import Utils.HibernateUtil;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import view_model.QLNhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    private Session hSession;
    public NhanVienRepository(){
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(NhanVien nv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(nv);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void update(NhanVien nv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(nv);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void detele(NhanVien nv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(nv);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public List<NhanVien> findALl(){
        String hql = "SELECT nsxObj FROM NhanVien nsxObj";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql,NhanVien.class);
        return query.getResultList();
    }
    public NhanVien findByMa(String ma){
        String hql = "SELECT nsxObj FROM NhanVien nsxObj WHERE nsxObj.Ma = ?1";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql,NhanVien.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
    public NhanVien login(String ma, String matKhau)
    {
        String hql = "SELECT nv FROM NhanVien nv " +
                "WHERE nv.Ma = ?1 AND nv.MatKhau = ?2";
        TypedQuery<NhanVien> q = this.hSession.createQuery(hql, NhanVien.class);
        q.setParameter(1, ma);
        q.setParameter(2, matKhau);

        try {
            NhanVien nv = q.getSingleResult();
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
    public NhanVien findById(UUID Id)
    {
        return this.hSession.find(NhanVien.class, Id);
    }

}
