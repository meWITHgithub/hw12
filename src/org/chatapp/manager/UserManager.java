package org.chatapp.manager;

import java.sql.SQLException;
import java.util.List;

import org.chatapp.dao.UserDao;
import org.chatapp.entity.ChatEntity;

public class UserManager implements Manager {
	UserDao userDao = new UserDao();

	@Override
	public void save(ChatEntity entity) throws SQLException {
		userDao.save(entity);
	}

	@Override
	public ChatEntity load(long id) throws SQLException {
		return userDao.load(id);
	}

	@Override
	public void update(ChatEntity entity) throws SQLException {
		userDao.update(entity);
	}

	@Override
	public void delete(long id) throws SQLException {
		userDao.delete(id);
	}

	@Override
	public List<ChatEntity> loadAll() throws SQLException {
		return userDao.loadAll();
	}

}
