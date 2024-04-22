package dao;

import entities.TheLoaiSach;
import entities.TheLoaiVanPhongPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class TheLoaiDao {
    private Connection con;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private String query;
    private int rsCheck;
    private EntityManager em;

    public TheLoaiDao() {
        this.em = Persistence.createEntityManagerFactory("JPA_ORM_MARIADB").createEntityManager();
    }

    public List<TheLoaiSach> getListTheLoaiSach() throws Exception {
        TypedQuery<TheLoaiSach> query = em.createQuery("SELECT t FROM TheLoaiSach t", TheLoaiSach.class);
        return query.getResultList();
    }

    public List<TheLoaiVanPhongPham> getListTheLoaiVanPhongPham() throws Exception{
        TypedQuery<TheLoaiVanPhongPham> query = em.createQuery("SELECT t FROM TheLoaiVanPhongPham t", TheLoaiVanPhongPham.class);
        return query.getResultList();
    }

    public boolean themTheLoaiSach(TheLoaiSach t) throws Exception {
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
            return false;
        }
    }

    public boolean themTheLoaiVanPhongPham(TheLoaiVanPhongPham t) throws Exception {
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
            return false;
        }
    }


    public TheLoaiSach timTheLoaiSach(String tenTheLoai) throws Exception {
        return (TheLoaiSach) em.createNativeQuery("SELECT * FROM TheLoaiSach WHERE tenTheLoai = ?", TheLoaiSach.class).setParameter(1, tenTheLoai).getSingleResult();
    }


    public TheLoaiVanPhongPham timTheLoaiVanPhongPham(String tenTheLoai) throws Exception {
        return (TheLoaiVanPhongPham) em.createNativeQuery("SELECT * FROM TheLoaiVanPhongPham WHERE tenTheLoai = ?", TheLoaiVanPhongPham.class).setParameter(1, tenTheLoai).getSingleResult();
    }

    public List<TheLoaiSach> getSachTheoTheLoai(String maTL) throws Exception {
        return em.createNativeQuery("SELECT * FROM TheLoaiSach WHERE maTheLoai = ?", TheLoaiSach.class).setParameter(1, maTL).getResultList();
    }

    public boolean kiemTraTonTaiTheLoaiVPP(String ten) throws Exception {
        Long count = (Long) em.createQuery("SELECT COUNT(t) FROM TheLoaiVanPhongPham t WHERE t.tenLoai = :ten")
                .setParameter("ten", ten)
                .getSingleResult();
        return count > 0;
    }

    public boolean kiemTraTonTaiTheLoaiSach(String ten) throws Exception {
        Long count = (Long) em.createQuery("SELECT COUNT(t) FROM TheLoaiSach t WHERE t.tenLoai = :ten")
                .setParameter("ten", ten)
                .getSingleResult();
        return count > 0;
    }


}
