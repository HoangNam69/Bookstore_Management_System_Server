package service.impl;

import dao.MauSacDao;
import entities.MauSac;
import service.MauSacService;

import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class MauSacServiceImpl extends UnicastRemoteObject implements MauSacService {
    MauSacDao mauSacDao = new MauSacDao();

    public MauSacServiceImpl() throws Exception {
        this.mauSacDao = new MauSacDao();
    }

    @Override
    public ArrayList<MauSac> getListMauSac() throws Exception {
        return mauSacDao.getListMauSac();
    }

    @Override
    public boolean themMauSac(MauSac mauSac) throws Exception {
        if (mauSacDao.kiemTraTonTaiMauSac(mauSac))
            return false;
        return mauSacDao.themMauSac(mauSac);
    }

    @Override
    public MauSac timMauSac(String mau) throws Exception {
        return mauSacDao.timMauSac(mau);
    }

    @Override
    public boolean capNhatMauSac(MauSac mauSac) throws Exception {
        return mauSacDao.capNhatMauSac(mauSac);
    }

    @Override
    public boolean xoaMauSac(String maMauSac) throws Exception {
        return mauSacDao.xoaMauSac(maMauSac);
    }

}
