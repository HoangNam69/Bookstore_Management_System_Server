package service;

import entities.SachLoi;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.List;

public interface SachLoiService extends Remote{
	public boolean themSachLoi(SachLoi sl) throws Exception;

	public boolean capNhatSoLuong(SachLoi sl) throws Exception;

	public List<SachLoi> getAllSachLoi() throws Exception;
	public boolean xoaSachLoi(String maSach, String loi) throws Exception;
}
