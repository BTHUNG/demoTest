package repositories;

import DomainModel.KhachHang;
import DomainModel.NSX;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import view_model.QLMauSac;
import view_model.QLNSX;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NSXRepository {
    private Session hSession;

    public NSXRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(NSX nsx) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(nsx);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(NSX nsx) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(nsx);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(NSX nsx) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(nsx);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }


    public List<NSX> findAll() {
        String hql = "SELECT cv FROM NSX cv ";
        TypedQuery<NSX> query = this.hSession.createQuery(hql,NSX.class);
        return query.getResultList();
    }
    public NSX findById(UUID Id) {
        return this.hSession.find(NSX.class, Id);
    }
    public NSX findByMa(String ma) {
        String hql = "SELECT cv FROM NSX cv WHERE cv.Ma = ?1";
        TypedQuery<NSX> query = this.hSession.createQuery(hql,NSX.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
