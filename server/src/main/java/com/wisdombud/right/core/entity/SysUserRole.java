package com.wisdombud.right.core.entity;

import javax.persistence.Entity;

import com.wisdombud.right.core.common.entity.BaseEntity;

@Entity
public class SysUserRole extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private Integer userId;
	private Integer roleId;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
