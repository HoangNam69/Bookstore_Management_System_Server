package dao;

import entities.ChiTietHoaDonDoiTra;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import util.DatabaseConnection;

import java.sql.SQLException;
import java.util.List;

public class ChiTietHoaDonDoiTraDao  {
	private EntityManager em;

	public ChiTietHoaDonDoiTraDao() throws Exception{
		em = DatabaseConnection.getInstance().getEntityManager();
	}
	public List<ChiTietHoaDonDoiTra> getCTHoaDonDoiTraTheoMaHoaDonDoiTra(String maHD) throws Exception {
		TypedQuery<ChiTietHoaDonDoiTra> query = em.createQuery(
				"SELECT c FROM ChiTietHoaDonDoiTra c WHERE c.hoaDonDoiTra.maHoaDonDoiTra = :maHD",
				ChiTietHoaDonDoiTra.class);
		query.setParameter("maHD", maHD);
		return query.getResultList();
	}



	public int themChiTietHoaDonDoiTra(ChiTietHoaDonDoiTra cthddt) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(cthddt);
			em.getTransaction().commit();
			return 1; // return 1 if the operation is successful
		} catch (Exception e) {
			e.printStackTrace(); // print detailed information about the exception
            try {
                throw new SQLException(e); // rethrow the exception as SQLException
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
	}
}

