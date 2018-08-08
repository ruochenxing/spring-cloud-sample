package net.zxjava.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 还有问题
 */
public class ErrorFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(ErrorFilter.class);

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		Throwable throwable = ctx.getThrowable();
		ZuulFilter filter = (ZuulFilter) ctx.get("fail.filter"); // 来自 MyFilterProcessor
		log.error("主动捕获异常 this is ErrorFilter: {} " + "from " + filter.filterType(), throwable.getCause().getMessage());
		// ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		// ctx.set("error.exception", throwable.getCause());
		return null;
	}

	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
