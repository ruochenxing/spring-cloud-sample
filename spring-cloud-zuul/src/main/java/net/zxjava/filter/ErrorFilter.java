package net.zxjava.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 统一异常处理
 * 
 * 请求生命周期的pre、route、post三个阶段中有异常抛出的时候都会进入error阶段的处理
 */
@Component
public class ErrorFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(ErrorFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		Throwable throwable = ctx.getThrowable();
		log.error("主动捕获异常 this is ErrorFilter: {} ", throwable.getCause().getMessage());
		return null;
		// ZuulFilter filter = (ZuulFilter) ctx.get("fail.filter"); // 来自
		// MyFilterProcessor
		// if (filter != null) {
		// log.error("主动捕获异常 this is ErrorFilter: {} " + "from " + filter.filterType(),
		// throwable.getCause().getMessage());
		// } else {
		// }
	}

	@Override
	public String filterType() {
		return FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
