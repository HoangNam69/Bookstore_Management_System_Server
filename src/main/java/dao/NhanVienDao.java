package dao;

import entities.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import util.DatabaseConnection;

import java.util.List;

public class NhanVienDao {
    private EntityManager em;

    public NhanVienDao() {
        this.em = DatabaseConnection.getInstance().getEntityManager();
    }

    public boolean themNhanvien(NhanVien nv) throws Exception {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(nv);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }

    }


    public List<NhanVien> getDSNhanVien() throws Exception {
        return em.createNativeQuery("SELECT * FROM NhanVien", NhanVien.class).getResultList();
    }

    public List<NhanVien> timDanhSachNhanVienTheoMa(String maNV) throws Exception {
        try {
            return em.createQuery("SELECT nv FROM NhanVien nv WHERE nv.maNhanVien LIKE :maNV", NhanVien.class)
                    .setParameter("maNV", "%" + maNV + "%")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public NhanVien timNhanVienTheoMa(String maNV) throws Exception {
        try {
            return (NhanVien) em.createNativeQuery("SELECT * FROM NhanVien WHERE maNhanVien=?", NhanVien.class)
                    .setParameter(1, maNV)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<NhanVien> timDSNhanVienTheoTen(String tenNV) throws Exception {
        try {
            return em.createQuery("SELECT nv FROM NhanVien nv WHERE nv.hoTenNhanVien LIKE :tenNV", NhanVien.class)
                    .setParameter("tenNV", "%" + tenNV + "%")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public NhanVien timNhanVienTheoTen(String tenNV) throws Exception {
        try {
            return (NhanVien) em.createNativeQuery("SELECT * FROM NhanVien WHERE hoTenNhanVien LIKE ?", NhanVien.class)
                    .setParameter(1, tenNV)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<NhanVien> timNhanVienTheoSDT(String sdt) throws Exception {
        try {
            return em.createQuery("SELECT nv FROM NhanVien nv WHERE nv.sDT LIKE :sdt", NhanVien.class)
                    .setParameter("sdt", "%" + sdt + "%")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<NhanVien> getListNhanVienByNameAndSDT(String tenNV, String sdt) throws Exception {
        return em.createQuery("SELECT nv FROM NhanVien nv WHERE nv.hoTenNhanVien LIKE :tenNV OR nv.sDT LIKE :sdt", NhanVien.class)
                .setParameter("tenNV", "%" + tenNV + "%")
                .setParameter("sdt", "%" + sdt + "%")
                .getResultList();
    }

    public boolean xoaNhanVien(String maNV) throws Exception {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            NhanVien nv = em.find(NhanVien.class, maNV);
            em.remove(nv);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean suaNhanVien(NhanVien nv) throws Exception {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            NhanVien nv1 = em.find(NhanVien.class, nv);
            em.merge(nv1);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public NhanVien getNhanVienByEmail(String email) throws Exception {
        try {
            return (NhanVien) em.createNativeQuery("SELECT * FROM NhanVien WHERE email = ?", NhanVien.class)
                    .setParameter(1, email)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public boolean updateOTP(String email, String OTP, Timestamp hetHanOTP) {
//        EntityTransaction tx = em.getTransaction();
//        try {
//            tx.begin();
//            int rs = em.createNativeQuery("UPDATE NhanVien SET OTP = ?, hetHanOTP = ? WHERE email = ?")
//                    .setParameter(1, OTP)
//                    .setParameter(2, hetHanOTP)
//                    .setParameter(3, email)
//                    .executeUpdate();
//            tx.commit();
//            return true;
//        } catch (Exception e) {
//            tx.rollback();
//            e.printStackTrace();
//            return false;
//        }
//    }

}
