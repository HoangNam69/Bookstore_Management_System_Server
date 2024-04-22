package service;

import entities.NhanVien;

import java.rmi.Remote;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface NhanVienService extends Remote{
	public boolean themNhanVien(NhanVien nv) throws SQLException;

	public NhanVien timNhanVienTheoMa(String maNV) throws SQLException;

	public boolean xoaNhanVien(String maNV) throws SQLException;

	public List<NhanVien> getDSNhanVien() throws SQLException;

	public List<NhanVien> timDSNhanVienTheoTen(String tenNV) throws SQLException;

	public boolean suaNhanVien(NhanVien nv) throws SQLException;

	public List<NhanVien> getNhanVienBanNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc);

	public List<NhanVien> getDoanhThuCuaNhanVien(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException;

	public List<NhanVien> timDanhSachNhanVienTheoMa(String maNV) throws SQLException;

	public List<NhanVien> timNhanVienTheoSDT(String sDT) throws SQLException;

	public List<NhanVien> getListNhanVienByNameAndSDT(String tenNV, String sdt);

	public NhanVien timNhanVienTheoTen(String tenNV) throws SQLException;

	public NhanVien getNhanVienByEmail(String email);

//	public boolean updateOTP(String gmail, String OTP, Timestamp hetHanOTP);
	
	public List<NhanVien> thongKeDoanhThu10NVBanNhieuNhat(LocalDate ngayBatDau, LocalDate ngayKetThuc);
}
