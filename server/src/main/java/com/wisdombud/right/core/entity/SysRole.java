package com.wisdombud.right.core.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wisdombud.right.core.common.entity.BaseEntity;

@Entity
public class SysRole extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	private String name;
	private String code;
	private String decription;
	private Integer sortIndex;
	@JsonIgnore
	@ManyToMany(targetEntity = SysUser.class, mappedBy = "roles")
	private Set<SysUser> users;
	@ManyToMany(targetEntity = SysMenu.class)
	@JoinTable(name = "sys_role_menu", inverseJoinColumns = @JoinColumn(name = "roleId"), joinColumns = @JoinColumn(name = "menuId"))
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
