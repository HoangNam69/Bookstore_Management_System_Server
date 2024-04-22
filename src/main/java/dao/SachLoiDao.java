package dao;

import entities.Sach;
import entities.SachLoi;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class SachLoiDao {
    private EntityManager em;

    public SachLoiDao() {
        this.em = Persistence.createEntityManagerFactory("JPA_ORM_MARIADB")
                .createEntityManager();
    }

    public boolean themSachLoi(SachLoi sl) throws Exception {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(sl);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean capNhatSoLuong(SachLoi sl) throws Exception {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(sl);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public List<SachLoi> getAllSachLoi() throws Exception {
        return em.createNativeQuery("SELECT * FROM SachLoi", SachLoi.class)
                .getResultList();
    }

    public boolean xoaSachLoi(String maSach, String loi) throws Exception {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            SachLoi sl = em.find(SachLoi.class, new SachLoi(new Sach(maSach), loi));
            em.remove(sl);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
