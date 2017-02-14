package com.wisdombud.right.client.entity;

import java.io.Serializable;

public abstract class BaseEntity<ID extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;
	private ID id;

	public ID getId() {
		return this.id;
	}

	public void setId(ID id) {
		this.id = id;
	}

}
