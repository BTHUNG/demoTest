package repositories;

import DomainModel.DongSP;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import view_model.QLDongSP;
import view_model.QLKhachHang;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DongSPReponsitory {

    private Session hSession;

    public DongSPReponsitory() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(DongSP qlcv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(qlcv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(DongSP qlcv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(qlcv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(DongSP qlcv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(qlcv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public DongSP findById(UUID Id) {
        return this.hSession.find(DongSP.class, Id);
    }

    public List<DongSP> findAll()
    {
        String hql = "SELECT khObj FROM DongSP khObj";
        TypedQuery<DongSP> query =
                this.hSession.createQuery(hql, DongSP.class);
        return query.getResultList();
    }

    public DongSP findByMa(String ma) {
        String hql = "SELECT khObj FROM KhachHang khObj WHERE khObj.Ma = ?1";
        TypedQuery<DongSP> query =
                this.hSession.createQuery(hql, DongSP.class);
        query.setParameter(1, ma);

        return query.getSingleResult();
    }}
