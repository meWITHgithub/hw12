package org.chatapp.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.chatapp.entity.ChatEntity;
import org.chatapp.entity.Message;
import org.chatapp.entity.User;

public class MessageDao extends DaoImpl {

	@Override
	public void save(ChatEntity entity) throws SQLException {
		Message message = null;
		if (entity instanceof Message) {
			message = (Message) entity;
		}
		String query = "INSERT INTO messages(text, creator) VALUES(?,?)";
		connection = DriverManager.getConnection(connectUrl);
		ps = connection.prepareStatement(query);
		ps.setString(1, message.getText());
		ps.setLong(2, message.getCreator().getId());
		ps.executeUpdate();
		ps.close();
		connection.close();
	}

	@Override
	public ChatEntity load(long id) throws SQLException {
		String query = "SELECT * FROM messages WHERE mid = ?";
		connection = DriverManager.getConnection(connectUrl);
		ps = connection.prepareStatement(query);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		Message message = null;
		UserDao userDao = new UserDao();
		while (rs.next()) {
			message = new Message();
			message.setId(rs.getLong("mid"));
			message.setText(rs.getString("text"));
			message.setDate(rs.getDate("date"));
			message.setCreator((User) userDao.load(rs.getLong("creator")));
		}
		ps.close();
		connection.close();
		return message;
	}

	@Override
	public void update(ChatEntity entity) throws SQLException {
		Message message = null;
		if (entity instanceof Message) {
			message = (Message) entity;
		}
		String query = "UPDATE messages SET text = ?, creator = ? WHERE mid = ?";
		connection = DriverManager.getConnection(connectUrl);
		ps = connection.prepareStatement(query);
		ps.setString(1, message.getText());
		ps.setLong(2, message.getCreator().getId());
		ps.setLong(3, message.getId());
		ps.executeUpdate();
		ps.close();
		connection.close();
	}

	@Override
	public void delete(long id) throws SQLException {
		String query = "DELETE FROM messages WHERE mid = ?";
		connection = DriverManager.getConnection(connectUrl);
		ps = connection.prepareStatement(query);
		ps.setLong(1, id);
		ps.executeUpdate();
		ps.close();
		connection.close();
	}

	@Override
	public List<ChatEntity> loadAll() throws SQLException {
		String query = "SELECT * FROM messages";
		List<ChatEntity> messageList = new ArrayList<>();
		connection = DriverManager.getConnection(connectUrl);
		ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		Message message;
		UserDao userDao = new UserDao();
		while (rs.next()) {
			message = new Message();
			message.setId(rs.getLong("mid"));
			message.setText(rs.getString("text"));
			message.setDate(rs.getDate("date"));
			message.setCreator((User) userDao.load(rs.getLong("creator")));
			messageList.add(message);
		}
		ps.close();
		connection.close();
		return messageList;
	}

	List<Message> userMessages(long id) throws SQLException {
		String query = "SELECT * FROM messages WHERE creator = ?";
		List<Message> msgList = new ArrayList<>();
		connection = DriverManager.getConnection(connectUrl);
		ps = connection.prepareStatement(query);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		Message message;
		UserDao userDao = new UserDao();
		while (rs.next()) {
			message = new Message();
			message.setId(rs.getLong("mid"));
			message.setText(rs.getString("text"));
			message.setCreator((User) userDao.load(rs.getLong("creator")));
			message.setDate(rs.getDate("date"));
			msgList.add(message);
		}
		ps.close();
		connection.close();
		return msgList;
	}

}
