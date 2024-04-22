package service.impl;

import dao.ChiTietHoaDonDoiTraDao;
import entities.ChiTietHoaDonDoiTra;
import service.ChiTietHoaDonDoiTraService;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ChiTietHoaDonDoiTraServiceImpl extends UnicastRemoteObject  implements ChiTietHoaDonDoiTraService {
	ChiTietHoaDonDoiTraDao chiTietHoaDonDoiTraDao = new ChiTietHoaDonDoiTraDao();
	public ChiTietHoaDonDoiTraServiceImpl() throws Exception {
		this.chiTietHoaDonDoiTraDao = new ChiTietHoaDonDoiTraDao();
	}
	@Override
	public List<ChiTietHoaDonDoiTra> getCTHoaDonDoiTraTheoMaHoaDonDoiTra(String maHD) throws Exception {
		// TODO Auto-generated method stub
		return chiTietHoaDonDoiTraDao.getCTHoaDonDoiTraTheoMaHoaDonDoiTra(maHD);
	}

	@Override
	public int themChiTietHoaDonDoiTra(ChiTietHoaDonDoiTra cthddt) throws Exception {
		// TODO Auto-generated method stub
		return chiTietHoaDonDoiTraDao.themChiTietHoaDonDoiTra(cthddt);
	}

}
