package org.chatapp.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.chatapp.entity.ChatEntity;
import org.chatapp.entity.User;

public class UserDao extends DaoImpl {

	@Override
	public void save(ChatEntity entity) throws SQLException {
		User user = null;
		if (entity instanceof User) {
			user = (User) entity;
		}
		String query = "INSERT INTO users(username, password) VALUES(?,?)";
		connection = DriverManager.getConnection(connectUrl);
		ps = connection.prepareStatement(query);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.executeUpdate();
		ps.close();
		connection.close();
	}

	@Override
	public ChatEntity load(long id) throws SQLException {
		String query = "SELECT * FROM users WHERE uid = ?";
		connection = DriverManager.getConnection(connectUrl);
		ps = connection.prepareStatement(query);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		User user = new User();
		MessageDao messageDao = new MessageDao();
		if (rs.next()) {
			user.setId(rs.getLong("uid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setMessages(messageDao.userMessages(rs.getLong("uid")));
		}
		ps.close();
		connection.close();
		return user;
	}

	@Override
	public void update(ChatEntity entity) throws SQLException {
		User user = null;
		if (entity instanceof User) {
			user = (User) entity;
		}
		String query = "UPDATE users SET username = ?, password = ? WHERE uid = ?";
		connection = DriverManager.getConnection(connectUrl);
		ps = connection.prepareStatement(query);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setLong(3, user.getId());
		ps.executeUpdate();
		ps.close();
		connection.close();
	}

	@Override
	public void delete(long id) throws SQLException {
		String query = "DELETE FROM users WHERE uid = ?";
		connection = DriverManager.getConnection(connectUrl);
		ps = connection.prepareStatement(query);
		ps.setLong(1, id);
		ps.executeUpdate();
		ps.close();
		connection.close();
	}

	@Override
	public List<ChatEntity> loadAll() throws SQLException {
		String query = "SELECT * FROM users";
		List<ChatEntity> userList = new ArrayList<>();
		connection = DriverManager.getConnection(connectUrl);
		ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		User user;
		MessageDao messageDao = new MessageDao();
		while (rs.next()) {
			user = new User();
			user.setId(rs.getLong("uid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setMessages(messageDao.userMessages(rs.getLong("uid")));
			userList.add(user);
		}
		ps.close();
		connection.close();
		return userList;
	}

}
