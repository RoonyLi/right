package com.wisdombud.right.client.common;

import com.wisdombud.right.client.entity.UserAuthenticInfo;

/**
 * @author joseph
 *         <p>
 *         用户认证信息的threadLocal
 *         </p>
 */
public final class UserThreadLocal {

	private static ThreadLocal<UserAuthenticInfo> userAuths = new ThreadLocal<UserAuthenticInfo>();

	public static void set(final UserAuthenticInfo info) {
		userAuths.set(info);
	}

	public static UserAuthenticInfo get() {
		return userAuths.get();
	}
}
