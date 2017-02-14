package com.wisdombud.right.client.entity;

import java.util.Set;

public class SysRole extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	private String name;
	private String code;
	private String decription;
	private Integer sortIndex;

	private Set<SysUser> users;

	private Set<SysMenu> menus;

	public Integer getSortIndex() {
		return this.sortIndex;
	}

	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}

	private Integer pid;
	private Integer pname;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDecription() {
		return this.decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getPname() {
		return this.pname;
	}

	public void setPname(Integer pname) {
		this.pname = pname;
	}

	public Set<SysUser> getUsers() {
		return this.users;
	}

	public void setUsers(Set<SysUser> users) {
		this.users = users;
	}

	public Set<SysMenu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<SysMenu> menus) {
		this.menus = menus;
	}

}
