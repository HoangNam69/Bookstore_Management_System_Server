package service.impl;

import dao.NhaCungCapDao;
import entities.NhaCungCap;
import service.NhaCungCapService;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class NhaCungCapServiceImpl extends UnicastRemoteObject implements NhaCungCapService {
	NhaCungCapDao nhaCungCapDao = new NhaCungCapDao();

public NhaCungCapServiceImpl() throws Exception {
		this.nhaCungCapDao = new NhaCungCapDao();
	}

	@Override
	public ArrayList<NhaCungCap> getListNhaCungCap(String loaiSanPham) {
		// TODO Auto-generated method stub
		return nhaCungCapDao.getListNhaCungCapTheoLoaiSanPham(loaiSanPham);
	}

	@Override
	public boolean themNhaCungCap(NhaCungCap t) {
		if(nhaCungCapDao.kiemTraTonTaiNCC(t.getTenNCC()))
			return false;
		return nhaCungCapDao.themNhaCungCap(t);
	}

	@Override
	public ArrayList<NhaCungCap> getAllListNhaCungCap()  {
		// TODO Auto-generated method stub
		return nhaCungCapDao.getAllListNhaCungCap();
	}

	@Override
	public NhaCungCap timNhaCungCap(String NCC) {
		// TODO Auto-generated method stub
		return nhaCungCapDao.timNhaCungCapTheoTen(NCC);
	}

}
