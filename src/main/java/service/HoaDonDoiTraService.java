package service;

import entities.HoaDonDoiTra;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.List;

public interface HoaDonDoiTraService extends Remote{
	public int themHoaDonDoiTra(HoaDonDoiTra hddt) throws Exception;
	public List<HoaDonDoiTra> getHoaDonDoiTraTheoMa(String maHDDT)throws Exception;
	public List<HoaDonDoiTra> getDSHoaDonDoiTra()throws Exception;
	public int editTienKhachTra(HoaDonDoiTra hddt)throws Exception;
	public List<HoaDonDoiTra> getMaHoaDonDoiTraByMaHDCu(String maHDCu)throws Exception;
	public int editTienPhaiTru(HoaDonDoiTra hddt)throws Exception;
	public List<HoaDonDoiTra> getToanBoDSHoaDonDoiTra()throws Exception;
	public HoaDonDoiTra timHoaDonDoiTraTheoMa(String maHoaDon)throws Exception;
	public List<HoaDonDoiTra> getHoaDonDoiTraTheoTen(String tenNV)throws Exception;
	public List<HoaDonDoiTra> getHoaDonDoiTraTheoSDT(String sdt)throws Exception;
	public List<HoaDonDoiTra> getHoaDonDoiTraTheoTenKH(String tenKH)throws Exception;
}
