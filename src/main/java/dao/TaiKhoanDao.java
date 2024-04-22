package dao;

import entities.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class TaiKhoanDao {

    private EntityManager em;

    public TaiKhoanDao() {
        this.em = DatabaseConnection.getInstance().getEntityManager();
    }

    public List<TaiKhoan> getList() throws Exception {
        TypedQuery<TaiKhoan> query = em.createQuery("SELECT t FROM TaiKhoan t", TaiKhoan.class);
        return query.getResultList();
    }

    public int insertAccount(TaiKhoan taiKhoan) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(taiKhoan);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Error inserting account: " + e.getMessage());
            return -1;
        }
    }

    public int xoaTaiKhoan(String maNhanVien) throws Exception {
        try {
            em.getTransaction().begin();
            TaiKhoan taiKhoan = em.find(TaiKhoan.class, maNhanVien);
            if (taiKhoan != null) {
                em.remove(taiKhoan);
                em.getTransaction().commit();
                return 1;
            }
            return 0; // Không tìm thấy tài khoản để xóa
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Error deleting account: " + e.getMessage());
            return -1;
        }
    }

    public TaiKhoan getTaiKhoanTheoMaNV(String maNV) throws Exception {
        TypedQuery<TaiKhoan> query = em.createQuery("SELECT t FROM TaiKhoan t WHERE t.nhanVien.maNhanVien = :maNV", TaiKhoan.class);
        query.setParameter("maNV", maNV);
        return query.getSingleResult();
    }

    public int doiMatKhau(String passMoi, String maNV) throws Exception {
        try {
            em.getTransaction().begin();
            // Lấy thông tin tài khoản dựa trên mã nhân viên
            TypedQuery<TaiKhoan> query = em.createQuery("SELECT t FROM TaiKhoan t WHERE t.nhanVien.maNhanVien = :maNV", TaiKhoan.class);
            query.setParameter("maNV", maNV);
            TaiKhoan taiKhoan = query.getSingleResult();

            // Cập nhật mật khẩu
            taiKhoan.setMatKhau(passMoi);
            em.getTransaction().commit();

            return 1; // Hoàn thành thành công
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Error updating password: " + e.getMessage());
            return -1; // Gặp lỗi
        }
    }
}
