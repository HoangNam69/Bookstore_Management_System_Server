package service;

import entities.ChatLieu;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface ChatLieuService extends Remote{
	public ArrayList<ChatLieu> getListChatLieu() throws Exception;
	public boolean themChatLieu(ChatLieu l) throws Exception;
	public boolean xoaChatLieu(String maChatLieu) throws Exception;;
	public List<ChatLieu> getChatLieu(String maChatLieu)throws Exception;
	public ChatLieu timChatLieu(String tenChatLieu) throws Exception;
}
