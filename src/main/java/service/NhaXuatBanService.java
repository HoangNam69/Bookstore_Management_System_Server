package service;

import entities.NhaXuatBan;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.ArrayList;

public interface NhaXuatBanService extends Remote{
	public ArrayList<NhaXuatBan> getListNhaXuatBan() throws Exception;

	public boolean themNhaXuatBan(NhaXuatBan t) throws Exception;

	public NhaXuatBan timNhaXuatBan(String NXB) throws SQLException;
}
