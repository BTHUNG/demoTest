package repositories;

import DomainModel.KhachHang;
import DomainModel.MauSac;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import view_model.QLCuaHang;
import view_model.QLKhachHang;
import view_model.QLMauSac;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MauSacRepository {
    private Session hSession;
    public MauSacRepository(){
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(MauSac qlms){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(qlms);
            this.hSession.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(MauSac qlms){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(qlms);
            this.hSession.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete(MauSac qlms){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(qlms);
            this.hSession.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public MauSac findById(UUID Id)
    {
        return this.hSession.find(MauSac.class,Id);
    }

    public List<MauSac> findAll()
    {
        String hql = "SELECT khObj FROM MauSac khObj";
        TypedQuery<MauSac> query =
                this.hSession.createQuery(hql, MauSac.class);
        return query.getResultList();
    }

    public MauSac findByMa(String ma){
        String hql = "SELECT khObj FROM MauSac khObj WHERE khObj.Ma = ?1";
        TypedQuery<MauSac> query =
                this.hSession.createQuery(hql, MauSac.class);
        query.setParameter(1, ma);

        return query.getSingleResult();
    }
}
