package com.wisdombud.right.core.entity;

import javax.persistence.Entity;

import com.wisdombud.right.core.common.entity.BaseEntity;

@Entity
public class SysRoleMenu extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private Integer menuId;
	private Integer roleId;

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}
