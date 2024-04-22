package service.impl;

import dao.HoaDonDao;
import dao.ThongKeDao;
import entities.HoaDon;
import service.HoaDonService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class HoaDonServiceImpl extends UnicastRemoteObject implements HoaDonService {
	HoaDonDao hoaDonDao = new HoaDonDao();
	ThongKeDao thongKeDao = new ThongKeDao();

	public HoaDonServiceImpl() throws Exception {
		this.hoaDonDao = new HoaDonDao();
		this.thongKeDao = new ThongKeDao();
	}

	@Override
	public int getSoLuongHoaDon(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws Exception {
		// TODO Auto-generated method stub
		return thongKeDao.getSoLuongHoaDon(ngayBatDau, ngayKetThuc);
	}

	@Override
	public double getDoanhThu(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws Exception {
		// TODO Auto-generated method stub
		return thongKeDao.getDoanhThu(ngayBatDau, ngayKetThuc);
	}

	@Override
	public double getDoanhThuTheoMaNhanVien(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maNV)
			throws Exception {
		// TODO Auto-generated method stub
		return thongKeDao.getDoanhThuTheoMaNhanVien(ngayBatDau, ngayKetThuc, maNV);
	}

	@Override
	public int getSoLuongHoaDonTheoMaNV(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maNV) throws Exception {
		// TODO Auto-generated method stub
		return thongKeDao.getSoLuongHoaDonTheoMaNV(ngayBatDau, ngayKetThuc, maNV);
	}

	@Override
	public int setNullChoMaNhanVienTrongHoaDon(String maNV) throws Exception{
		// TODO Auto-generated method stub
		return hoaDonDao.setNullChoMaNhanVienTrongHoaDon(maNV);
	}

	@Override
	public List<HoaDon> getHoaDonTheoMa(String maHD) throws Exception{
		// TODO Auto-generated method stub
		return hoaDonDao.getHoaDonTheoMa(maHD);
	}

	@Override
	public List<HoaDon> getDSHoaDon() throws Exception {
		// TODO Auto-generated method stub
		return hoaDonDao.getDSHoaDon();
	}

	@Override
	public int doiThongTinHoaDonSauKhiXoa(String tenNV) throws Exception{
		// TODO Auto-generated method stub
		return hoaDonDao.doiThongTinHoaDonSauKhiXoa(tenNV);
	}

	@Override
	public int themHoaDon(HoaDon hd) throws Exception {
		// TODO Auto-generated method stub
		return hoaDonDao.themHoaDon(hd);
	}

	@Override
	public List<HoaDon> getHoaDonThuong() throws Exception{
		// TODO Auto-generated method stub
		return hoaDonDao.getHoaDonThuong();
	}

	@Override
	public HoaDon timHoaDonTheoMa(String maHoaDon)throws Exception {
		return hoaDonDao.timHoaDonTheoMa(maHoaDon);
	}

	@Override
	public List<HoaDon> getHoaDonTheoTen(String tenNV)throws Exception {
			return hoaDonDao.getHoaDonTheoTen(tenNV);
	}

	@Override
	public List<HoaDon> timHoaDonTheoSDT(String sdt)throws Exception {
		return hoaDonDao.timHoaDonTheoSDT(sdt);
	}

	@Override
	public List<HoaDon> timHoaDonTheoTenKH(String ten)throws Exception {
			return hoaDonDao.timHoaDonTheoTenKH(ten);
	}


}
