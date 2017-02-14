package com.wisdombud.right.client.entity;

import java.util.Set;

public class SysMenu extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	private String name;
	private String keyWord;
	private Integer sortIndex;
	private String url;
	private String description;
	private Integer pid;
	private String pname;
	private Set<SysRole> roles;
	private Set<SysButton> buttons;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKeyWord() {
		return this.keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getSortIndex() {
		return this.sortIndex;
	}

	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Set<SysRole> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}

	public Set<SysButton> getButtons() {
		return this.buttons;
	}

	public void setButtons(Set<SysButton> buttons) {
		this.buttons = buttons;
	}

}
