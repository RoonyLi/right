package com.wisdombud.right.client.author;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.wisdombud.right.client.common.HttpKit;
import com.wisdombud.right.client.common.RightCodeEnum;
import com.wisdombud.right.client.common.RightConstants;
import com.wisdombud.right.client.entity.UserAuthenticInfoWrap;
import com.wisdombud.right.core.exception.user.UserBlockedException;
import com.wisdombud.right.core.exception.user.UserException;
import com.wisdombud.right.core.exception.user.UserNotExistsException;
import com.wisdombud.right.core.exception.user.UserPasswordNotMatchException;
import com.wisdombud.right.core.exception.user.UserPasswordRetryLimitExceedException;

public class Authorizor {
	public static com.wisdombud.right.client.entity.UserAuthenticInfo login(HttpServletRequest request, String userName,
			String password) throws UserException {
		final Map<String, String> data = new HashMap<>();
		data.put("userName", userName);
		data.put("password", password);
		final String result = HttpKit.get(RightConstants.RIGHT_SERVER_URL, data);
		// 反序列化后
		final Gson gson = new Gson();
		final UserAuthenticInfoWrap infoWrap = gson.fromJson(result, UserAuthenticInfoWrap.class);
		if (infoWrap.getCode() == 200) {
			// 放到session裡面，登錄后跳轉使用
			request.getSession().setAttribute(RightConstants.SESSION_USER, infoWrap.getUserAuthenticInfo());
			return infoWrap.getUserAuthenticInfo();
		}
		if (infoWrap.getCode() == RightCodeEnum.UserNotExists.getCode()) {
			throw new UserNotExistsException();
		}
		if (infoWrap.getCode() == RightCodeEnum.UserBlocked.getCode()) {
			throw new UserBlockedException(infoWrap.getMsg());
		}
		if (infoWrap.getCode() == RightCodeEnum.UserPasswordNotMatch.getCode()) {
			throw new UserPasswordNotMatchException();
		}
		if (infoWrap.getCode() == RightCodeEnum.UserPasswordRetryLimitExceed.getCode()) {
			throw new UserPasswordRetryLimitExceedException(3);
		}
		throw new UserException(infoWrap.getCode() + "", infoWrap.getMsg());
	}
}
