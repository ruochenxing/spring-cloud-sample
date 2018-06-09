package net.zxjava.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

	/**
	 * 过滤器是否执行
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
		Object accessToken = request.getParameter("accessToken");
		if (accessToken == null) {
			log.warn("access token is empty");
			ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
			ctx.setResponseStatusCode(401);// 设置返回错误码
			return null;
		}
		log.info("access token ok");
		return null;
	}

	/**
	 * 过滤器类型 过滤器执行点 pre表示请求在路由前执行
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 请求执行顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
