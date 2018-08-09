package net.zxjava.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

//@Component
public class AccessFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

	/**
	 * 过滤器是否执行
	 */
	@Override
	public boolean shouldFilter() {
		return false;
	}

	/**
	 * 权限校验
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
		Object accessToken = request.getParameter("accessToken");
		if (accessToken == null) {
			log.error("access token is empty");
			ctx.setSendZuulResponse(false);// 让zuul过滤该请求，不对其进行路由
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
		return FilterConstants.PRE_TYPE;
	}

	/**
	 * 请求执行顺序 数字越大，越晚执行
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
