/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wisdombud.right.core.common.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> extends AbstractEntity<ID> {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private ID id;

	@Override
	public ID getId() {
		return this.id;
	}

	@Override
	public void setId(ID id) {
		this.id = id;
	}

}
