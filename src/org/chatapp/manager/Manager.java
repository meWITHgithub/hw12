package org.chatapp.manager;

import java.sql.SQLException;
import java.util.List;

import org.chatapp.entity.ChatEntity;

public interface Manager {
	public void save(ChatEntity entity) throws SQLException;

	public ChatEntity load(long id) throws SQLException;

	public void update(ChatEntity entity) throws SQLException;

	public void delete(long id) throws SQLException;

	public List<ChatEntity> loadAll() throws SQLException;
}
