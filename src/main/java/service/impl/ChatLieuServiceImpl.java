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

	public ChatLieuServiceImpl() throws Exception{
		this.chatLieuDao = new ChatLieuDao();
	}

	@Override
	public ArrayList<ChatLieu> getListChatLieu() throws Exception {
		return chatLieuDao.getListChatLieu();
	}

	@Override
	public boolean themChatLieu(ChatLieu l) throws Exception {
		return chatLieuDao.themChatLieu(l);
	}

	@Override
	public boolean xoaChatLieu(String maChatLieu)throws Exception {
		return false;
	}

	@Override
	public List<ChatLieu> getChatLieu(String maChatLieu)throws Exception {
		return chatLieuDao.getChatLieu(maChatLieu);
	}

	@Override
	public ChatLieu timChatLieu(String tenChatLieu) throws Exception {
		return chatLieuDao.timChatLieu(tenChatLieu);
	}
}