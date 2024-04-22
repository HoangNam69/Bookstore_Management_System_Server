package service;

import entities.NhanVien;

import java.rmi.Remote;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface NhanVienService extends Remote {
    public boolean themNhanVien(NhanVien nv) throws Exception;

    public NhanVien timNhanVienTheoMa(String maNV) throws Exception;

    public boolean xoaNhanVien(String maNV) throws Exception;

    public List<NhanVien> getDSNhanVien() throws Exception;

    public List<NhanVien> timDSNhanVienTheoTen(String tenNV) throws Exception;

    public boolean suaNhanVien(NhanVien nv) throws Exception;

    public List<NhanVien> getNhanVienBanNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws Exception;

    public List<NhanVien> getDoanhThuCuaNhanVien(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws Exception;

    public List<NhanVien> timDanhSachNhanVienTheoMa(String maNV) throws Exception;

    public List<NhanVien> timNhanVienTheoSDT(String sDT) throws Exception;

    public List<NhanVien> getListNhanVienByNameAndSDT(String tenNV, String sdt) throws Exception;

    public NhanVien timNhanVienTheoTen(String tenNV) throws Exception;

    public NhanVien getNhanVienByEmail(String email) throws Exception;

//	public boolean updateOTP(String gmail, String OTP, Timestamp hetHanOTP);

    public List<NhanVien> thongKeDoanhThu10NVBanNhieuNhat(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws Exception;
}
