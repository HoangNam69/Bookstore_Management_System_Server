package service;

import entities.ChiTietHoaDonDoiTra;

import java.rmi.Remote;
import java.util.List;

public interface ChiTietHoaDonDoiTraService extends Remote{
	public List<ChiTietHoaDonDoiTra> getCTHoaDonDoiTraTheoMaHoaDonDoiTra(String maHD)throws Exception;

	public int themChiTietHoaDonDoiTra(ChiTietHoaDonDoiTra cthddt) throws Exception;
}
