package service;

import entities.SachLoi;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.List;

public interface SachLoiService extends Remote{
	public boolean themSachLoi(SachLoi sl) throws SQLException;

	public boolean capNhatSoLuong(SachLoi sl);

	public List<SachLoi> getAllSachLoi() throws SQLException;
	public boolean xoaSachLoi(String maSach, String loi);
}
