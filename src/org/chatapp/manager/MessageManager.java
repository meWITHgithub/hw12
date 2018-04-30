package org.chatapp.manager;

import java.sql.SQLException;
import java.util.List;

import org.chatapp.dao.MessageDao;
import org.chatapp.entity.ChatEntity;

public class MessageManager implements Manager {
	MessageDao messageDao = new MessageDao();

	@Override
	public void save(ChatEntity entity) throws SQLException {
		messageDao.save(entity);
	}

	@Override
	public ChatEntity load(long id) throws SQLException {
		return messageDao.load(id);
	}

	@Override
	public void update(ChatEntity entity) throws SQLException {
		messageDao.update(entity);
	}

	@Override
	public void delete(long id) throws SQLException {
		messageDao.delete(id);
	}

	@Override
	public List<ChatEntity> loadAll() throws SQLException {
		return messageDao.loadAll();
	}

}
