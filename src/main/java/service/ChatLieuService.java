package service;

import entities.ChatLieu;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface ChatLieuService extends Remote{
	public ArrayList<ChatLieu> getListChatLieu() throws RemoteException;

	public boolean themChatLieu(ChatLieu l) throws RemoteException;

	public boolean xoaChatLieu(String maChatLieu) throws RemoteException;;

	public List<ChatLieu> getChatLieu(String maChatLieu)throws RemoteException;

	public ChatLieu timChatLieu(String tenChatLieu) throws RemoteException;
}
