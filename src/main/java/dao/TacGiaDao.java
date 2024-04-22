package dao;

import entities.TacGia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class TacGiaDao {
    private Connection con;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private String query;
    private int rsCheck;
    private EntityManager em;

    public TacGiaDao() {
        this.em = Persistence.createEntityManagerFactory("JPA_ORM_MARIADB").createEntityManager();
    }

    public List<TacGia> getListTacGia() throws Exception {
        TypedQuery<TacGia> query = em.createQuery("SELECT t FROM TacGia t", TacGia.class);
        return query.getResultList();
    }

    public List<TacGia> getTacGia(String maTacGia) throws Exception {
        TypedQuery<TacGia> query = em.createQuery("SELECT t FROM TacGia t WHERE t.maTacGia = :maTacGia", TacGia.class);
        query.setParameter("maTacGia", maTacGia);
        return query.getResultList();
    }

    public boolean themTacGia(TacGia t) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Error inserting author: " + e.getMessage());
            return false;
        }
    }

    public boolean xoaTacGia(String maTacGia) throws Exception {
        try {
            em.getTransaction().begin();
            TacGia tacGia = em.find(TacGia.class, maTacGia);
            if (tacGia != null) {
                em.remove(tacGia);
                em.getTransaction().commit();
                return true;
            }
            return false; // Không tìm thấy tác giả để xóa
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Error deleting author: " + e.getMessage());
            return false;
        }
    }

    public TacGia timTacGia(String tenTacGia) throws Exception {
        TypedQuery<TacGia> query = em.createQuery("SELECT t FROM TacGia t WHERE t.tenTacGia = :tenTacGia", TacGia.class);
        query.setParameter("tenTacGia", tenTacGia);
        List<TacGia> results = query.getResultList();
        if (!results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    public boolean kiemTraTonTaiTacGia(String tenTacGia) throws Exception {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(t) FROM TacGia t WHERE t.tenTacGia = :tenTacGia", Long.class);
        query.setParameter("tenTacGia", tenTacGia);
        return query.getSingleResult() > 0;
    }
}
