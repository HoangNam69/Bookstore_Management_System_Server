package service;

import entities.Sach;
import entities.SanPham;
import entities.VanPhongPham;

import java.rmi.Remote;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface SanPhamService extends Remote {

    public boolean xoaSanPham(String maSP) throws Exception;

    public int getSoLuongSachLoi() throws Exception;

    public int getSoLuongVPPTon() throws Exception;

    public int getSoLuongSachTon() throws Exception;

    public List<SanPham> getSanPhamBanNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws Exception;

    public SanPham timSanPhamTheoMa(String maSP) throws Exception;

    public int getSoLuongBanCuaSanPhamChayNhat(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws Exception;

    public Sach getSachTheoMaSP(String maSP) throws Exception;

    public VanPhongPham getVPPTheoMaSP(String maSP) throws Exception;

    public ArrayList<Sach> getListSach(String maSach, String tenSP, String maTheLoai, Long giaTu, Long giaDen,
                                       String maTacGia, String maNXB, String maNCC, boolean hetHang) throws Exception;

    public ArrayList<VanPhongPham> getListVanPhongPham(String maVPP, String tenVPP, String theLoaiVPP, Long giaTu,
                                                       Long giaDen, String maChatLieu, String maXuatXu, String maNCC, boolean hetHang) throws Exception;

    public String getMaSPMax() throws Exception;

    public Sach timSanPhamTheoMaSach(String maSach) throws Exception;

    public VanPhongPham timSanPhamTheoMaVPP(String maVPP) throws Exception;

    public boolean capNhatSanPham(String maSP, SanPham temp) throws Exception;

    public boolean themSanPham(SanPham sanPham) throws Exception;

    public List<Sach> getAllSach() throws Exception;

    public Sach getSachTheoTen(String ten) throws Exception;

    public int capNhatSoLuongSanPham(SanPham sanPham) throws Exception;

    public List<VanPhongPham> getAllVPP() throws Exception;

    public VanPhongPham getVPPTheoTen(String ten) throws Exception;

    public SanPham getSanPhamTheoMa(String masp) throws Exception;

    public SanPham timSanPhamTheoMa1(String maSP) throws Exception;

}
