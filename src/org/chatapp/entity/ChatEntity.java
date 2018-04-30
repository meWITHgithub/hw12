package org.chatapp.entity;

public abstract class ChatEntity {
	protected long id;

	public ChatEntity() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
