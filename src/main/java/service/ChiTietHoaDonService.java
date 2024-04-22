package service;

import entities.ChiTietHoaDon;
import entities.HoaDon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ChiTietHoaDonService extends Remote {
	public List<ChiTietHoaDon> getCTHoaDonTheoMaHoaDon(String maHD) throws Exception;
	public ArrayList<ChiTietHoaDon> getCTHDTheoHoaDon(HoaDon hoaDon) throws Exception;
	public List<ChiTietHoaDon> getAllCTHD() throws Exception;
	public boolean addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon)throws Exception;
	public double getTien(String maHD)throws Exception;
}
