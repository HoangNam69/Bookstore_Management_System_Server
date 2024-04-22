package service.impl;

import dao.SachLoiDao;
import entities.SachLoi;
import service.SachLoiService;

import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

public class SachLoiServiceImpl extends UnicastRemoteObject implements SachLoiService {
    SachLoiDao sachLoiDao = new SachLoiDao();

public SachLoiServiceImpl() throws Exception {
        this.sachLoiDao = new SachLoiDao();
    }

    @Override
    public boolean themSachLoi(SachLoi sl) {
        // TODO Auto-generated method stub
        return sachLoiDao.themSachLoi(sl);
    }

    @Override
    public boolean capNhatSoLuong(SachLoi sl) {
        // TODO Auto-generated method stub
        return sachLoiDao.capNhatSoLuong(sl);
    }

    @Override
    public List<SachLoi> getAllSachLoi() throws SQLException {
        // TODO Auto-generated method stub
        return sachLoiDao.getAllSachLoi();
    }

    @Override
    public boolean xoaSachLoi(String maSach, String loi) {
        return sachLoiDao.xoaSachLoi(maSach, loi);
    }

}
