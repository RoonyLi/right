package com.wisdombud.right.client.common;

public enum RightCodeEnum {
	UserBlocked(401), UserNotExists(402), UserPasswordNotMatch(403), UserPasswordRetryLimitExceed(405);
	private RightCodeEnum(int code) {
		this.code = code;
	}

	private int code;

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
