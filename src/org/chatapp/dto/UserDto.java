package org.chatapp.dto;

import org.chatapp.entity.User;

public class UserDto {
	private long id;
	private String username;
	private String password;

	public UserDto() {
		super();
	}

	public UserDto(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
