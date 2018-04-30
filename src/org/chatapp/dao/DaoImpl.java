package org.chatapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class DaoImpl implements Dao {
	protected Connection connection;
	protected PreparedStatement ps;
	protected String connectUrl = "jdbc:mysql://127.0.0.1/chatapp?user=root";

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
		}
	}
}
