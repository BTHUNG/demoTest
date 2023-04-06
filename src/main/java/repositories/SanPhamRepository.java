package repositories;

import DomainModel.SanPham;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import view_model.QLCuaHang;
import view_model.QLSanPham;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {
    private Session hSession;

    public SanPhamRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(SanPham qlsp) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(qlsp);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(SanPham qlsp) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(qlsp);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(SanPham qlsp) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(qlsp);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public SanPham findById(UUID Id) {
        return this.hSession.find(SanPham.class, Id);
    }

    public List<SanPham> findAll() {
        String hql = "SELECT khObj FROM SanPham khObj";
        TypedQuery<SanPham> query =
                this.hSession.createQuery(hql, SanPham.class);
        return query.getResultList();
    }

    public SanPham findByMa(String ma) {
        String hql = "SELECT khObj FROM SanPham khObj WHERE khObj.Ma = ?1";
        TypedQuery<SanPham> query =
                this.hSession.createQuery(hql, SanPham.class);
        query.setParameter(1, ma);

        return query.getSingleResult();
    }
}
