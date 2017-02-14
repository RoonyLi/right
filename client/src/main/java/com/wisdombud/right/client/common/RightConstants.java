package com.wisdombud.right.client.common;

/**
 * 用户登录、权限等相关的常量
 *
 * @author joseph
 */
public final class RightConstants {

	/**
	 * session中放置用户信息的属性名称
	 */
	public static String SESSION_USER = "SESSION_USER";

	/**
	 * session中放置登录成功后跳转url的属性名称
	 */
	public static String BACK_URL = "BACK_URL";

	/**
	 * 跟权限相关的log的name
	 */
	public static String RIGHT_LOG_NAME = "rightLog";

	/**
	 * 初始化的时候需要初始化的登录页面url
	 */
	public static String LOGIN_URL;

	/**
	 * 权限服务器的url
	 */
	public static String RIGHT_SERVER_URL;
}
