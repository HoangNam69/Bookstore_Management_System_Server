package service;

import entities.XuatXu;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface XuatXuService extends Remote{
	public ArrayList<XuatXu> getListXuatXu() throws Exception;

	public boolean themXuatXu(XuatXu x) throws Exception;

	public boolean xoaXuatXu(String maXuatXu);

	public List<XuatXu> getXuatXu(String maXuatXu);

	public XuatXu timXuatXu(String XuatXu) throws SQLException;
}
