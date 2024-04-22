package service.impl;

import dao.TacGiaDao;
import entities.TacGia;
import service.TacGiaService;

import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TacGiaServiceImpl extends UnicastRemoteObject implements TacGiaService {
	TacGiaDao tacGiaDao = new TacGiaDao();

	public TacGiaServiceImpl() throws Exception {
		this.tacGiaDao = new TacGiaDao();
	}

	@Override
	public ArrayList<TacGia> getListTacGia() throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<TacGia>) tacGiaDao.getListTacGia();
	}

	@Override
	public boolean themTacGia(TacGia t) throws Exception {
		if(tacGiaDao.kiemTraTonTaiTacGia(t.getTenTacGia()))
			return false;
		return tacGiaDao.themTacGia(t);
	}

	@Override
	public boolean xoaTacGia(String maTacGia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TacGia> getTacGia(String maTacGia) {
		// TODO Auto-generated method stub
		return tacGiaDao.getTacGia(maTacGia);
	}

	@Override
	public TacGia timTacGia(String TacGia) throws SQLException {
		// TODO Auto-generated method stub
		return tacGiaDao.timTacGia(TacGia);
	}

}
