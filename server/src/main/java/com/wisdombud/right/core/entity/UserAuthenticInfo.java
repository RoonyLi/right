package com.wisdombud.right.core.entity;

import java.util.Set;

public class UserAuthenticInfo {

	private int code;
	private SysUser currentUser;
	private Set<SysMenu> sysMenu;

	private Set<SysResource> sysResources;

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public SysUser getCurrentUser() {
		return this.currentUser;
	}

	public void setCurrentUser(SysUser currentUser) {
		this.currentUser = currentUser;
	}

	public Set<SysMenu> getSysMenu() {
		return this.sysMenu;
	}

	public void setSysMenu(Set<SysMenu> sysMenu) {
		this.sysMenu = sysMenu;
	}

	public Set<SysResource> getSysResources() {
		return this.sysResources;
	}

	public void setSysResources(Set<SysResource> sysResources) {
		this.sysResources = sysResources;
	}

}
