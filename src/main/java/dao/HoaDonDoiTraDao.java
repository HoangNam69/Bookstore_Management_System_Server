package dao;

import entities.HoaDonDoiTra;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import util.DatabaseConnection;

import java.util.List;

public class HoaDonDoiTraDao {
	private EntityManager em;

	public HoaDonDoiTraDao()throws Exception {
		em = DatabaseConnection.getInstance().getEntityManager();
	}

	public int themHoaDonDoiTra(HoaDonDoiTra hddt)throws Exception {
		em.getTransaction().begin();
		em.persist(hddt);
		em.getTransaction().commit();
		return 1;
	}

	public List<HoaDonDoiTra> getHoaDonDoiTraTheoMa(String maHDDT)throws Exception {
		String query = "SELECT h FROM HoaDonDoiTra h WHERE h.maHoaDonDoiTra = :maHDDT";
		return em.createQuery(query, HoaDonDoiTra.class)
				.setParameter("maHDDT", maHDDT)
				.getResultList();
	}

	public List<HoaDonDoiTra> getDSHoaDonDoiTra() throws Exception{
		String query = "SELECT h FROM HoaDonDoiTra h";
		return em.createQuery(query, HoaDonDoiTra.class).getResultList();
	}

	public int editTienKhachTra(HoaDonDoiTra hddt) throws Exception{
		em.getTransaction().begin();
		hddt = em.merge(hddt);
		em.getTransaction().commit();
		return 1;
	}

	public int editTienPhaiTru(HoaDonDoiTra hddt)throws Exception {
		em.getTransaction().begin();
		hddt = em.merge(hddt);
		em.getTransaction().commit();
		return 1;
	}

	public List<HoaDonDoiTra> getMaHoaDonDoiTraByMaHDCu(String maHDCu)throws Exception {
		String query = "SELECT h FROM HoaDonDoiTra h WHERE h.hoaDon.maHoaDon = :maHDCu";
		return em.createQuery(query, HoaDonDoiTra.class)
				.setParameter("maHDCu", maHDCu)
				.getResultList();
	}

	public List<HoaDonDoiTra> getToanBoDSHoaDonDoiTra()throws Exception {
		String query = "SELECT h FROM HoaDonDoiTra h";
		return em.createQuery(query, HoaDonDoiTra.class).getResultList();
	}

	public HoaDonDoiTra timHoaDonDoiTraTheoMa(String maHoaDon)throws Exception {
		HoaDonDoiTra hoaDonDT = em.find(HoaDonDoiTra.class, maHoaDon);
		return hoaDonDT;
	}

	public List<HoaDonDoiTra> getHoaDonDoiTraTheoTen(String tenNV)throws Exception {
		String query = "SELECT h FROM HoaDonDoiTra h WHERE h.nhanVien.hoTenNhanVien LIKE :tenNV";
		return em.createQuery(query, HoaDonDoiTra.class)
				.setParameter("tenNV", "%" + tenNV + "%")
				.getResultList();
	}

	public List<HoaDonDoiTra> getHoaDonDoiTraTheoSDT(String sdt)throws Exception {
		String query = "SELECT h FROM HoaDonDoiTra h WHERE h.khachHang.sDT = :sdt";
		return em.createQuery(query, HoaDonDoiTra.class)
				.setParameter("sdt", sdt)
				.getResultList();
	}

	public List<HoaDonDoiTra> getHoaDonDoiTraTheoTenKH(String tenKH)throws Exception {
		String query = "SELECT h FROM HoaDonDoiTra h WHERE h.khachHang.hoTenKhachHang LIKE :tenKH";
		return em.createQuery(query, HoaDonDoiTra.class)
				.setParameter("tenKH", "%" + tenKH + "%")
				.getResultList();
	}

}
