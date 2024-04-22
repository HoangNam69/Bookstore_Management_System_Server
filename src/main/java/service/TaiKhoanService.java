package service;

import entities.TaiKhoan;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.ArrayList;

public interface TaiKhoanService extends Remote {
    public int insertAccount(TaiKhoan taiKhoan) throws Exception;

    public ArrayList<TaiKhoan> getList() throws Exception;

    public int xoaTaiKhoan(String maNhanVien) throws Exception;

    public TaiKhoan getTaiKhoanTheoMaNV(String maNV) throws Exception;

    public int doiMatKhau(String passMoi, String maNV) throws Exception;
}
