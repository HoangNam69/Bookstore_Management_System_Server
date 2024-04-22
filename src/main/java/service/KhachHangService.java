package service;

import entities.KhachHang;

import java.rmi.Remote;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface KhachHangService extends Remote{
	public int themKhachHang(KhachHang kh) throws Exception;
	public int getSoLuongHoaDonCuaKhachHangTheoMa(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maKH)throws Exception;
	public int capNhatKhachHang(KhachHang kh)throws Exception;
	public double getTongTienCuaKhachHangTop1(LocalDate ngayBatDau, LocalDate ngayKetThuc)throws Exception;
	public double getTongTienCuaKhachHangTheoMa(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maKH)throws Exception;
	public KhachHang timKhachHangTheoMa(String maKH) throws Exception;
	public KhachHang timKhachHangBangSDT(String sdt) throws Exception;
	public List<KhachHang> getDSKhachHang() throws Exception;
	public List<KhachHang> getKhachHangMuaNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc)throws Exception;
	public List<KhachHang> getTop10KHThanThiet(LocalDate ngayBatDau, LocalDate ngayKetThuc)throws Exception;
	public ArrayList<KhachHang> timKhachHangTheoSDT(String maKH) throws Exception;
	public ArrayList<KhachHang> timKhachHangTheoTen(String tenKH) throws Exception;
	public ArrayList<KhachHang> getListKhachHangByNameAndSDT(String maNhanVien, String tenNhanVien)throws Exception;
}
