package repositories;

import DomainModel.ChiTietSP;
import DomainModel.NhanVien;
import Utils.HibernateUtil;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {
    private Session hSession;
    public ChiTietSPRepository(){
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(ChiTietSP cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(ChiTietSP cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(ChiTietSP cv){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public ChiTietSP findById(UUID Id) {
        return this.hSession.find(ChiTietSP.class, Id);
    }

    public List<ChiTietSP> findAll()
    {
        String hql = "SELECT khObj FROM ChiTietSP khObj";
        TypedQuery<ChiTietSP> query =
                this.hSession.createQuery(hql, ChiTietSP.class);
        return query.getResultList();
    }

    public ChiTietSP getById(UUID id) {
        ChiTietSP chiTietSP = new ChiTietSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP where id =: id");
            query.setParameter("id", id);
            chiTietSP = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSP;
    }


}
