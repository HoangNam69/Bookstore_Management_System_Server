package dao;

import entities.HoaDon;
import jakarta.persistence.*;

import java.util.List;

public class HoaDonDao {
	private EntityManager em;

	public HoaDonDao()throws Exception {
		em = Persistence.createEntityManagerFactory("JPA_ORM_MARIADB").createEntityManager();
	}

	public int setNullChoMaNhanVienTrongHoaDon(String maNV)throws Exception {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Query query = em.createQuery("UPDATE HoaDon h SET h.nhanVien = NULL WHERE h.nhanVien.maNhanVien = :maNV");
		query.setParameter("maNV", maNV);
		int result = query.executeUpdate();
		transaction.commit();
		return result;
	}

	public List<HoaDon> getDSHoaDon()throws Exception {
		TypedQuery<HoaDon> query = em.createQuery("SELECT h FROM HoaDon h ORDER BY h.ngayLapHoaDon DESC", HoaDon.class);
		return query.getResultList();
	}

	public int doiThongTinHoaDonSauKhiXoa(String tenNV)throws Exception {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Query query = em.createQuery("UPDATE HoaDon h SET h.nhanVien = NULL WHERE h.nhanVien IS NULL");
		int result = query.executeUpdate();
		transaction.commit();
		return result;
	}


	public int themHoaDon(HoaDon hd)throws Exception {
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(hd);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	public List<HoaDon> getHoaDonTheoMa(String maHD)throws Exception {
		TypedQuery<HoaDon> query = em.createQuery("SELECT h FROM HoaDon h WHERE h.maHoaDon = :maHD", HoaDon.class);
		query.setParameter("maHD", maHD);
		return query.getResultList();
	}

	public List<HoaDon> getHoaDonThuong()throws Exception{
		TypedQuery<HoaDon> query = em.createQuery("SELECT h FROM HoaDon h", HoaDon.class);
		return query.getResultList();
	}

	public HoaDon timHoaDonTheoMa(String maHoaDon)throws Exception {
		return em.find(HoaDon.class, maHoaDon);
	}

	public List<HoaDon> getHoaDonTheoTen(String tenNV)throws Exception {
		TypedQuery<HoaDon> query = em.createQuery("SELECT h FROM HoaDon h JOIN h.nhanVien n WHERE n.hoTenNhanVien LIKE :tenNV", HoaDon.class);
		query.setParameter("tenNV", "%" + tenNV + "%");
		return query.getResultList();
	}

	public List<HoaDon> timHoaDonTheoSDT(String sdt)throws Exception {
		TypedQuery<HoaDon> query = em.createQuery("SELECT h FROM HoaDon h WHERE h.khachHang.sDT = :sdt", HoaDon.class);
		query.setParameter("sdt", sdt);
		return query.getResultList();
	}

	public List<HoaDon> timHoaDonTheoTenKH(String ten)throws Exception {
		TypedQuery<HoaDon> query = em.createQuery("SELECT h FROM HoaDon h JOIN h.khachHang k WHERE k.hoTenKhachHang LIKE :ten", HoaDon.class);
		query.setParameter("ten", "%" + ten + "%");
		return query.getResultList();
	}


}
