package service.impl;

import dao.KhachHangDao;
import dao.ThongKeDao;
import entities.KhachHang;
import service.KhachHangService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KhachHangServiceImpl extends UnicastRemoteObject implements KhachHangService {
	public static int errors = 0;
	public static int errorsThem = 0;
	ThongKeDao thongKeDao = new ThongKeDao();
	KhachHangDao khachhang_dao = new KhachHangDao();

	public KhachHangServiceImpl() throws Exception {
		khachhang_dao = new KhachHangDao();
	}

	@Override
	public List<KhachHang> getDSKhachHang() throws Exception {
		// TODO Auto-generated method stub
		return khachhang_dao.getDSKhachHang();
	}

	public int themKhachHang(KhachHang kh) throws Exception {
		if (!(kh.getHoTenKhachHang()
				.matches("[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊ"
						+ "ỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]*"))) {
			errors = 1;
			return -1;
		} else if (!(kh.getsDT().matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b"))) {
			errors = 2;
			return -1;
		} else {
			return khachhang_dao.themKhachHang(kh);
		}
	}

	@Override
	public KhachHang timKhachHangTheoMa(String maKH) throws Exception {
		// TODO Auto-generated method stub

		return khachhang_dao.timKhachHangTheoMa(maKH);
	}

	@Override
	public int capNhatKhachHang(KhachHang kh) throws Exception {
		// TODO Auto-generated method stub
		if (!(kh.getHoTenKhachHang()
				.matches("[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊ"
						+ "ỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]*"))) {
			errorsThem = 1;
			return -1;
		} else if (!(kh.getsDT().matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b"))) {
			errorsThem = 2;
			return -1;
		} else {
			return khachhang_dao.capNhatKhachHang(kh);
		}

	}

	@Override
	public List<KhachHang> getKhachHangMuaNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc)throws Exception {
		// TODO Auto-generated method stub
		return thongKeDao.getKhachHangMuaNhieuNhatTheoNgayTuChon(ngayBatDau, ngayKetThuc);
	}

	@Override
	public double getTongTienCuaKhachHangTop1(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws Exception {
		// TODO Auto-generated method stub
		return thongKeDao.getTongTienCuaKhachHangTop1(ngayBatDau, ngayKetThuc);
	}

	@Override
	public List<KhachHang> getTop10KHThanThiet(LocalDate ngayBatDau, LocalDate ngayKetThuc)throws Exception {
		// TODO Auto-generated method stub
		return thongKeDao.getTop10KHThanThiet(ngayBatDau, ngayKetThuc);
	}

	@Override
	public int getSoLuongHoaDonCuaKhachHangTheoMa(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maKH)
			throws Exception {
		// TODO Auto-generated method stub
		return thongKeDao.getSoLuongHoaDonCuaKhachHangTheoMa(ngayBatDau, ngayKetThuc, maKH);
	}

	@Override
	public double getTongTienCuaKhachHangTheoMa(LocalDate ngayBatDau, LocalDate ngayKetThuc, String maKH)
            throws Exception {
		// TODO Auto-generated method stub
		return thongKeDao.getTongTienCuaKhachHangTheoMa(ngayBatDau, ngayKetThuc, maKH);
	}

	@Override
	public ArrayList<KhachHang> timKhachHangTheoSDT(String sDT) throws Exception {
		// TODO Auto-generated method stub

		return khachhang_dao.timKhachHangTheoSDT(sDT);
	}

	@Override
	public ArrayList<KhachHang> timKhachHangTheoTen(String tenKH) throws Exception {
		// TODO Auto-generated method stub
		return khachhang_dao.timKhachHangTheoTen(tenKH);
	}

	@Override
	public ArrayList<KhachHang> getListKhachHangByNameAndSDT(String tenNhanVien, String sDT) throws Exception {
		// TODO Auto-generated method stub
		return khachhang_dao.getListKhachHangByNameAndSDT(tenNhanVien, sDT);
	}

	@Override
	public KhachHang timKhachHangBangSDT(String sdt) throws Exception {
		// TODO Auto-generated method stub
		return khachhang_dao.timKhachHangBangSDT(sdt);
	}

}
