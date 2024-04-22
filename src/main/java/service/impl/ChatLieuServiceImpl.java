package service.impl;

import dao.ChatLieuDao;
import entities.ChatLieu;
import service.ChatLieuService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatLieuServiceImpl extends UnicastRemoteObject  implements ChatLieuService {
	private ChatLieuDao chatLieuDao;

	public ChatLieuServiceImpl() throws RemoteException{
		this.chatLieuDao = new ChatLieuDao();
	}

	@Override
	public ArrayList<ChatLieu> getListChatLieu() throws RemoteException {
		return chatLieuDao.getListChatLieu();
	}

	@Override
	public boolean themChatLieu(ChatLieu l) throws RemoteException {
		return chatLieuDao.themChatLieu(l);
	}

	@Override
	public boolean xoaChatLieu(String maChatLieu) {
		return false;
	}

	@Override
	public List<ChatLieu> getChatLieu(String maChatLieu) {
		return chatLieuDao.getChatLieu(maChatLieu);
	}

	@Override
	public ChatLieu timChatLieu(String tenChatLieu) throws RemoteException {
		return chatLieuDao.timChatLieu(tenChatLieu);
	}
}