package service;

import entities.HoaDon;

import java.rmi.Remote;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface HoaDonService extends Remote{
	public int getSoLuongHoaDon(LocalDate ngayBatDau, LocalDate ngayKetThuc)throws Exception;
	public double getDoanhThu(LocalDate ngayBatDau, LocalDate ngayKetThuc)throws Exception;
	public double getDoanhThuTheoMaNhanVien(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maNV)throws Exception;
	public int getSoLuongHoaDonTheoMaNV(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maNV)throws Exception;
	public int setNullChoMaNhanVienTrongHoaDon(String maNV)throws Exception;
	public List<HoaDon> getHoaDonTheoMa(String maHD)throws Exception;
	public List<HoaDon> getDSHoaDon() throws Exception;
	public int doiThongTinHoaDonSauKhiXoa(String tenNV)throws Exception;
	public int themHoaDon(HoaDon hd) throws Exception;
	public List<HoaDon> getHoaDonThuong()throws Exception;
	public HoaDon timHoaDonTheoMa(String maHoaDon)throws Exception;
	public List<HoaDon> getHoaDonTheoTen(String tenNV)throws Exception;
	public List<HoaDon> timHoaDonTheoSDT(String sdt)throws Exception;
	public List<HoaDon> timHoaDonTheoTenKH(String ten)throws Exception;
}