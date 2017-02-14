package com.wisdombud.right.core.exception.user;

import com.wisdombud.right.core.exception.BaseException;

/**
 * Version: 1.0
 */
public class UserException extends BaseException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public UserException(String code, Object[] args) {
		super("user", code, args, null);
	}

	public UserException(String code, String... msgs) {
		super("user", code, msgs);
	}

}
