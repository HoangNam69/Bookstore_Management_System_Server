package service;

import entities.MauSac;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MauSacService extends Remote{
    public ArrayList<MauSac> getListMauSac() throws Exception;

    public boolean themMauSac(MauSac mauSac) throws Exception;

    public MauSac timMauSac(String Mau) throws SQLException;

    public boolean capNhatMauSac(MauSac mauSac) throws SQLException;

    public boolean xoaMauSac(String maMauSac) throws SQLException;
}
