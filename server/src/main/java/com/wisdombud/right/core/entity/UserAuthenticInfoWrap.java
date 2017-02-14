package com.wisdombud.right.core.entity;

public class UserAuthenticInfoWrap {
	private int code;
	private String msg;
	private UserAuthenticInfo userAuthenticInfo;

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public UserAuthenticInfo getUserAuthenticInfo() {
		return this.userAuthenticInfo;
	}

	public void setUserAuthenticInfo(UserAuthenticInfo userAuthenticInfo) {
		this.userAuthenticInfo = userAuthenticInfo;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
