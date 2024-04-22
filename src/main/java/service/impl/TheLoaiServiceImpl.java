package service.impl;

import dao.TheLoaiDao;
import entities.TheLoaiSach;
import entities.TheLoaiVanPhongPham;
import service.TheLoaiService;

import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheLoaiServiceImpl extends UnicastRemoteObject implements TheLoaiService {
    TheLoaiDao theLoaiDao = new TheLoaiDao();

    public TheLoaiServiceImpl() throws Exception {
        this.theLoaiDao = new TheLoaiDao();
    }

    @Override
    public ArrayList<TheLoaiSach> getListTheLoaiSach() throws Exception {
        // TODO Auto-generated method stub
        return (ArrayList<TheLoaiSach>) theLoaiDao.getListTheLoaiSach();
    }

    @Override
    public ArrayList<TheLoaiVanPhongPham> getListTheLoaiVanPhongPham() throws Exception {
        // TODO Auto-generated method stub
        return (ArrayList<TheLoaiVanPhongPham>) theLoaiDao.getListTheLoaiVanPhongPham();
    }

    @Override
    public boolean themTheLoaiSach(TheLoaiSach t) throws Exception {
        if (theLoaiDao.kiemTraTonTaiTheLoaiSach(t.getTenLoai())) {
            return false;
        }
        return theLoaiDao.themTheLoaiSach(t);
    }

    @Override
    public boolean themTheLoaiVanPhongPham(TheLoaiVanPhongPham t) throws Exception {
        if (theLoaiDao.kiemTraTonTaiTheLoaiVPP(t.getTenLoai())) {
            return false;
        }
        return theLoaiDao.themTheLoaiVanPhongPham(t);
    }

    @Override
    public TheLoaiSach timTheLoaiSach(String TheLoai) throws Exception {
        // TODO Auto-generated method stub
        return theLoaiDao.timTheLoaiSach(TheLoai);
    }

    @Override
    public TheLoaiVanPhongPham timTheLoaiVanPhongPham(String TheLoai) throws Exception {
        // TODO Auto-generated method stub
        return theLoaiDao.timTheLoaiVanPhongPham(TheLoai);
    }

    @Override
    public List<TheLoaiSach> getSachTheoTheLoai(String maTL) throws Exception {
        // TODO Auto-generated method stub
        return theLoaiDao.getSachTheoTheLoai(maTL);
    }

}
