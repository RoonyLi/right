package com.wisdombud.right.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import com.wisdombud.right.core.entity.SysUser;

public final class UserPasswordUtil {

	public static void encodePassword(SysUser user) {
		final String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
		final SimpleHash hash = new SimpleHash("MD5", user.getPassword(), user.getUserName() + salt2, 2);
		user.setPassword(hash.toHex());
		user.setSalt(salt2);
	}

	public static boolean checkPassword(String password, SysUser user) {
		final SimpleHash hash = new SimpleHash("MD5", password, user.getUserName() + user.getSalt(), 2);
		return hash.toHex().equals(user.getPassword());
	}
}
