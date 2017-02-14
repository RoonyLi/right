package com.wisdombud.right.core.entity;

import javax.persistence.Entity;

import com.wisdombud.right.core.common.entity.BaseEntity;

@Entity
public class SysUserResource extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private Integer userId;
	private Integer resoureceId;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getResoureceId() {
		return this.resoureceId;
	}

	public void setResoureceId(Integer resoureceId) {
		this.resoureceId = resoureceId;
	}

}
