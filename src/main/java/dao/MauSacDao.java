package dao;

import entities.MauSac;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;

public class MauSacDao {

    private EntityManager em;

    public MauSacDao() {
        em = Persistence.createEntityManagerFactory("JPA_ORM_MARIADB")
                .createEntityManager();
    }

    public ArrayList<MauSac> getListMauSac() {
        return (ArrayList<MauSac>) em.createNativeQuery("SELECT maMauSac, tenMau FROM MauSac", MauSac.class)
                .getResultList();
    }

    public boolean themMauSac(MauSac mauSac) {

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            em.persist(mauSac);

            tx.commit();

            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public MauSac timMauSac(String mau) {
        try {
            return (MauSac) em.createNativeQuery("SELECT * FROM MauSac WHERE tenMau = ?", MauSac.class)
                    .setParameter(1, mau)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

    public boolean kiemTraTonTaiMauSac(MauSac mauSac) {
        return em.createNativeQuery("SELECT * FROM MauSac WHERE tenMau = ?", MauSac.class)
                .setParameter(1, mauSac.getTenMau())
                .getResultList().size() > 0;
    }

    public boolean capNhatMauSac(MauSac mauSac) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            em.merge(mauSac);

            tx.commit();

            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean xoaMauSac(String maMauSac) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            MauSac mauSac = em.find(MauSac.class, maMauSac);
            em.remove(mauSac);

            tx.commit();

            return true;
        }catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }

        return false;
    }
}
