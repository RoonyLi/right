package com.wisdombud.right.client.entity;

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
