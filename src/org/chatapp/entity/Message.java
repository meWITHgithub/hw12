package org.chatapp.entity;

import java.sql.Date;

public class Message extends ChatEntity {
	private String text;
	private User creator;
	private Date date;

	public Message() {
		super();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
