package service;

import entities.TaiKhoan;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.ArrayList;

public interface TaiKhoanService extends Remote{
	public int insertAccount(TaiKhoan taiKhoan);

	public ArrayList<TaiKhoan> getList();

	public int xoaTaiKhoan(String maNhanVien);

	public TaiKhoan getTaiKhoanTheoMaNV(String maNV) throws SQLException;

	public int doiMatKhau(String passMoi, String maNV);
}
