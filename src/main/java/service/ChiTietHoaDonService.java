package service;

import entities.ChiTietHoaDon;
import entities.HoaDon;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ChiTietHoaDonService extends Remote {
	public List<ChiTietHoaDon> getCTHoaDonTheoMaHoaDon(String maHD);

	public ArrayList<ChiTietHoaDon> getCTHDTheoHoaDon(HoaDon hoaDon);

	public List<ChiTietHoaDon> getAllCTHD() throws SQLException;

	public boolean addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);
	
	public double getTien(String maHD);
}
