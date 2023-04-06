package repositories;

import DomainModel.ChucVu;
import DomainModel.NhanVien;
import Utils.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import view_model.QLCuaHang;
import view_model.QlChucVu;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public void insert(ChucVu cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void update(ChucVu cv){
        try{
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            this.hSession.getTransaction().rollback();
        }
    }
    public List<ChucVu> findALl(){
        String hql = "SELECT cvObj FROM ChucVu cvObj";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql,ChucVu.class);
        return query.getResultList();
    }
    public ChucVu findByMa(String ma){
        String hql = "SELECT cvObj FROM ChucVu cvObj WHERE cvObj.Ma = ?1";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql,ChucVu.class);
        query.setParameter(1,ma);
        return query.getSingleResult();

    }
    public void delete(ChucVu cv){
       try {
           this.hSession.getTransaction().begin();
           this.hSession.delete(cv);
           this.hSession.getTransaction().commit();
       }catch (Exception e){
           this.hSession.getTransaction().rollback();
       }
       }
    public ChucVu findById(UUID Id)
    {
        return this.hSession.find(ChucVu.class, Id);
    }
}
