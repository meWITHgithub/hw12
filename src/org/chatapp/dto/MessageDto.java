package org.chatapp.dto;

import java.sql.Date;

public class MessageDto {
	private long mid;
	private String text;
	private UserDto creator;
	private Date date;

	public MessageDto() {
		super();
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
