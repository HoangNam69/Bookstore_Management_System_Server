package service.impl;

import dao.NhaXuatBanDao;
import entities.NhaXuatBan;
import service.NhaXuatBanService;

import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class NhaXuatBanServiceImpl extends UnicastRemoteObject implements NhaXuatBanService {
	NhaXuatBanDao nhaXuatBanDao = new NhaXuatBanDao();

	public NhaXuatBanServiceImpl() throws Exception {
		this.nhaXuatBanDao = new NhaXuatBanDao();
	}

	@Override
	public ArrayList<NhaXuatBan> getListNhaXuatBan() throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<NhaXuatBan>) nhaXuatBanDao.getListNhaXuatBan();
	}

	@Override
	public boolean themNhaXuatBan(NhaXuatBan t) throws Exception {
		if(nhaXuatBanDao.kiemTraTonTaiNXB(t.getTenNXB()))
			return false;
		return nhaXuatBanDao.themNhaXuatBan(t);
	}

	@Override
	public NhaXuatBan timNhaXuatBan(String NXB) throws SQLException {
		// TODO Auto-generated method stub
		return nhaXuatBanDao.timNhaXuatBan(NXB);
	}

}
