package org.chatapp.dto;

import java.sql.Date;

import org.chatapp.entity.Message;

public class MessageDto {
	private long mid;
	private String text;
	private UserDto creator;
	private Date date;

	public MessageDto() {
		super();
	}

	public MessageDto(Message message) {
		this.mid = message.getId();
		this.text = message.getText();
		this.creator = new UserDto(message.getCreator());
	}

	public long getMid() {
		return mid;
	}

	public void setMid(long mid) {
		this.mid = mid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UserDto getCreator() {
		return creator;
	}

	public void setCreator(UserDto creator) {
		this.creator = creator;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
