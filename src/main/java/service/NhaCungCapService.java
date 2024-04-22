package service;

import entities.NhaCungCap;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.ArrayList;

public interface NhaCungCapService extends Remote{
	public ArrayList<NhaCungCap> getListNhaCungCap(String loaiSanPham) throws Exception;

	public ArrayList<NhaCungCap> getAllListNhaCungCap() throws Exception;

	public boolean themNhaCungCap(NhaCungCap t) throws Exception;

	public NhaCungCap timNhaCungCap(String NCC) throws SQLException;
}
