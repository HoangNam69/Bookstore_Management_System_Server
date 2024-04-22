package service;

import entities.TheLoaiSach;
import entities.TheLoaiVanPhongPham;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TheLoaiService extends Remote{
	public ArrayList<TheLoaiSach> getListTheLoaiSach() throws Exception;

	public ArrayList<TheLoaiVanPhongPham> getListTheLoaiVanPhongPham() throws Exception;

	public boolean themTheLoaiSach(TheLoaiSach t) throws Exception;

	public boolean themTheLoaiVanPhongPham(TheLoaiVanPhongPham t) throws Exception;

	public TheLoaiSach timTheLoaiSach(String TheLoai) throws SQLException;

	public TheLoaiVanPhongPham timTheLoaiVanPhongPham(String TheLoai) throws SQLException;

	public List<TheLoaiSach> getSachTheoTheLoai(String maTL);
}
