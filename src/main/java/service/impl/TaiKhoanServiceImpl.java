package service.impl;

import dao.TaiKhoanDao;
import entities.TaiKhoan;
import service.TaiKhoanService;

import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaiKhoanServiceImpl  extends UnicastRemoteObject implements TaiKhoanService {
	TaiKhoanDao taiKhoanDao = new TaiKhoanDao();

	public TaiKhoanServiceImpl() throws Exception {
		this.taiKhoanDao = new TaiKhoanDao();
	}

	@Override
	public int insertAccount(TaiKhoan taiKhoan) {
		// TODO Auto-generated method stub
		return taiKhoanDao.insertAccount(taiKhoan);
	}

	@Override
	public ArrayList<TaiKhoan> getList() {
		// TODO Auto-generated method stub
		return (ArrayList<TaiKhoan>) taiKhoanDao.getList();
	}

	@Override
	public int xoaTaiKhoan(String maNhanVien) {
		// TODO Auto-generated method stub
		return taiKhoanDao.xoaTaiKhoan(maNhanVien);
	}

	@Override
	public TaiKhoan getTaiKhoanTheoMaNV(String maNV) throws SQLException {
		// TODO Auto-generated method stub
		return taiKhoanDao.getTaiKhoanTheoMaNV(maNV);
	}

	@Override
	public int doiMatKhau(String passMoi, String maNV) {
		// TODO Auto-generated method stub
		return taiKhoanDao.doiMatKhau(passMoi, maNV);
	}

}
