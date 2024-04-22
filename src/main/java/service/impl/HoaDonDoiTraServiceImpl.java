package service.impl;

import dao.HoaDonDoiTraDao;
import entities.HoaDonDoiTra;
import service.HoaDonDoiTraService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

public class HoaDonDoiTraServiceImpl extends UnicastRemoteObject implements HoaDonDoiTraService {
	HoaDonDoiTraDao hoaDonDoiTraDao = new HoaDonDoiTraDao();

	public HoaDonDoiTraServiceImpl() throws Exception {
		this.hoaDonDoiTraDao = new HoaDonDoiTraDao();
	}

	@Override
	public int themHoaDonDoiTra(HoaDonDoiTra hddt) throws Exception {
		// TODO Auto-generated method stub
		return hoaDonDoiTraDao.themHoaDonDoiTra(hddt);
	}

	@Override
	public List<HoaDonDoiTra> getHoaDonDoiTraTheoMa(String maHDDT)throws Exception {
		// TODO Auto-generated method stub
		return hoaDonDoiTraDao.getHoaDonDoiTraTheoMa(maHDDT);
	}

	@Override
	public List<HoaDonDoiTra> getDSHoaDonDoiTra() throws Exception {
		// TODO Auto-generated method stub
		return hoaDonDoiTraDao.getDSHoaDonDoiTra();
	}

	@Override
	public int editTienKhachTra(HoaDonDoiTra hddt) throws Exception{
		// TODO Auto-generated method stub
		return hoaDonDoiTraDao.editTienKhachTra(hddt);
	}

	@Override
	public List<HoaDonDoiTra> getMaHoaDonDoiTraByMaHDCu(String maHDCu) throws Exception{
		// TODO Auto-generated method stub
		return hoaDonDoiTraDao.getMaHoaDonDoiTraByMaHDCu(maHDCu);
	}

	@Override
	public int editTienPhaiTru(HoaDonDoiTra hddt)throws Exception {
		// TODO Auto-generated method stub
		return hoaDonDoiTraDao.editTienPhaiTru(hddt);
	}

	@Override
	public List<HoaDonDoiTra> getToanBoDSHoaDonDoiTra() throws Exception {
		// TODO Auto-generated method stub
		return hoaDonDoiTraDao.getToanBoDSHoaDonDoiTra();
	}

	@Override
	public HoaDonDoiTra timHoaDonDoiTraTheoMa(String maHoaDon)throws Exception {
		return hoaDonDoiTraDao.timHoaDonDoiTraTheoMa(maHoaDon);
	}

	@Override
	public List<HoaDonDoiTra> getHoaDonDoiTraTheoTen(String tenNV) throws Exception {
		// TODO Auto-generated method stub
		return hoaDonDoiTraDao.getHoaDonDoiTraTheoTen(tenNV);
	}

	@Override
	public List<HoaDonDoiTra> getHoaDonDoiTraTheoSDT(String sdt)throws Exception {
		// TODO Auto-generated method stub
		return hoaDonDoiTraDao.getHoaDonDoiTraTheoSDT(sdt);
	}

	@Override
	public List<HoaDonDoiTra> getHoaDonDoiTraTheoTenKH(String tenKH)throws Exception {
		// TODO Auto-generated method stub
		return hoaDonDoiTraDao.getHoaDonDoiTraTheoTenKH(tenKH);
	}

}
