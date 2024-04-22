package dao;

import entities.NhaCungCap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;

public class NhaCungCapDao {

    private EntityManager em;

    public NhaCungCapDao() throws Exception{
        em = Persistence.createEntityManagerFactory("JPA_ORM_MARIADB")
                .createEntityManager();
    }

    public ArrayList<NhaCungCap> getListNhaCungCapTheoLoaiSanPham(String loaiSanPham) throws Exception{
        try {
            return (ArrayList<NhaCungCap>) em.createNativeQuery("SELECT ncc.* FROM NhaCungCap as ncc " +
                            "INNER JOIN SanPham as sp ON ncc.maNCC = sp.maNCC " +
                            "WHERE sp.loaiSanPham LIKE ?", NhaCungCap.class)
                    .setParameter(1, loaiSanPham)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean themNhaCungCap(NhaCungCap ncc)throws Exception {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            em.persist(ncc);

            tx.commit();

            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<NhaCungCap> getAllListNhaCungCap() throws Exception{
        return (ArrayList<NhaCungCap>) em.createNativeQuery("SELECT * FROM NhaCungCap", NhaCungCap.class).getResultList();
    }

    public NhaCungCap timNhaCungCapTheoTen(String tenNCC) throws Exception{
        try {
            return (NhaCungCap) em.createNativeQuery("SELECT * FROM NhaCungCap WHERE tenNCC = ?", NhaCungCap.class)
                    .setParameter(1, tenNCC)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean kiemTraTonTaiNCC(String ten) throws Exception{
        return em.createNativeQuery("SELECT * FROM NhaCungCap WHERE tenNCC = ?", NhaCungCap.class)
                .setParameter(1, ten)
                .getResultList().size() > 0;
    }
}
