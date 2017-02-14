package com.wisdombud.right.core.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * @author joseph
 *
 */
public class BaseException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -6393474641367358828L;

	// 所属模块
	private final String module;

	/**
	 * 错误码
	 */
	private final String code;

	/**
	 * 错误码对应的参数
	 */
	private final Object[] args;

	/**
	 * 错误消息
	 */
	private final String defaultMessage;

	public BaseException(String module, String code, Object[] args, String defaultMessage) {
		this.module = module;
		this.code = code;
		this.args = args;
		this.defaultMessage = defaultMessage;
	}

	public BaseException(String module, String code, Object[] args) {
		this(module, code, args, null);
	}

	public BaseException(String module, String defaultMessage) {
		this(module, null, null, defaultMessage);
	}

	public BaseException(String code, Object[] args) {
		this(null, code, args, null);
	}

	public BaseException(String defaultMessage) {
		this(null, null, null, defaultMessage);
	}

	@Override
	public String getMessage() {
		String message = null;
		if (!StringUtils.isEmpty(this.code)) {
			message = "code:[" + this.code + "],args:[" + this.args + "]";
		}
		if (message == null) {
			message = this.defaultMessage;
		}
		return message;
	}

	public String getModule() {
		return this.module;
	}

	public String getCode() {
		return this.code;
	}

	public Object[] getArgs() {
		return this.args;
	}

	public String getDefaultMessage() {
		return this.defaultMessage;
	}

	@Override
	public String toString() {
		return this.getClass() + "{" + "module='" + this.module + '\'' + ", message='" + this.getMessage() + '\'' + '}';
	}
}
