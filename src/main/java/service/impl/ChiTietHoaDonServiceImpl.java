package service.impl;

import dao.ChiTietHoaDonDao;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import service.ChiTietHoaDonService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonServiceImpl extends UnicastRemoteObject implements ChiTietHoaDonService {
	private ChiTietHoaDonDao chiTietHoaDonDao;

	public ChiTietHoaDonServiceImpl() throws Exception {
		this.chiTietHoaDonDao = new ChiTietHoaDonDao();
	}


	@Override
	public List<ChiTietHoaDon> getCTHoaDonTheoMaHoaDon(String maHD)throws Exception {
		return chiTietHoaDonDao.getCTHoaDonTheoMaHoaDon(maHD);
	}

	@Override
	public ArrayList<ChiTietHoaDon> getCTHDTheoHoaDon(HoaDon hoaDon)throws Exception {
		return chiTietHoaDonDao.getCTHDTheoHoaDon(hoaDon);
	}

	@Override
	public List<ChiTietHoaDon> getAllCTHD()throws Exception {
		return chiTietHoaDonDao.getAllCTHD();
	}

	@Override
	public boolean addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon)throws Exception {
		return  chiTietHoaDonDao.addChiTietHoaDon(chiTietHoaDon);
	}

	@Override
	public double getTien(String maHD)throws Exception {
		return chiTietHoaDonDao.getTien(maHD);
	}
}
