package com.wisdombud.right.client.entity;

import java.util.Set;

public class SysResource extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	private String name;
	private String url;
	private Integer sortIndex;
	private String keyWord;
	private Integer pid;
	private String pname;
	private Set<SysUser> users;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSortIndex() {
		return this.sortIndex;
	}

	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getKeyWord() {
		return this.keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;

	public Set<SysUser> getUsers() {
		return this.users;
	}

	public void setUsers(Set<SysUser> users) {
		this.users = users;
	}

}
