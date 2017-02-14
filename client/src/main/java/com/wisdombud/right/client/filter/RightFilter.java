package com.wisdombud.right.client.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wisdombud.right.client.common.RightConstants;
import com.wisdombud.right.client.common.UserThreadLocal;
import com.wisdombud.right.client.entity.UserAuthenticInfo;

public class RightFilter implements Filter {

	private static Log LOGGER = LogFactory.getLog(RightConstants.RIGHT_LOG_NAME);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		RightConstants.RIGHT_SERVER_URL = filterConfig.getInitParameter("rightServerUrl");
		if (RightConstants.RIGHT_SERVER_URL == null || "".equals(RightConstants.RIGHT_SERVER_URL)) {
			throw new RuntimeException("权限拦截器初始化失败，请配置权限系统地址，key=rightServerUrl");
		}
		RightConstants.LOGIN_URL = filterConfig.getInitParameter("loginUrl");
		if (RightConstants.LOGIN_URL == null || "".equals(RightConstants.LOGIN_URL)) {
			throw new RuntimeException("权限拦截器初始化失败，请配置登录页面地址,key=loginUrl");
		}
		// TODO: 考虑其他类似常量值是否也在此进行配置
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(String.format(
					"**************权限系统初始化参数信息如下********************\r\n		权限服务器地址：%s \r\n		登录页面url：%s ",
					RightConstants.RIGHT_SERVER_URL, RightConstants.LOGIN_URL));
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final HttpSession session = ((HttpServletRequest) request).getSession();
		if (session.isNew() || null == session.getAttribute(RightConstants.SESSION_USER)) {
			// 新session，跳转到登录页面
			session.setAttribute(RightConstants.BACK_URL, ((HttpServletRequest) request).getRequestURL().toString());
			((HttpServletResponse) response).sendRedirect(RightConstants.LOGIN_URL);
			return;
		}
		// 登录成功
		final com.wisdombud.right.client.entity.UserAuthenticInfo info = (UserAuthenticInfo) session
				.getAttribute(RightConstants.SESSION_USER);
		// 放到threadlocal中
		UserThreadLocal.set(info);
	}

	@Override
	public void destroy() {

	}

}
