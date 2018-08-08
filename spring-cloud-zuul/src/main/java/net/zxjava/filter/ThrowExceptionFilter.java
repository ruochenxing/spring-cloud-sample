package net.zxjava.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

/**
 * spring-cloud默认抛异常后交由 SendErrorFilter 处理，直接输出在控制台 ，如果需要主动捕获，请看 ErrorFilter
 */
@Component
public class ThrowExceptionFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(ThrowExceptionFilter.class);

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public Object run() {
		log.info("this is pre filter,it will throw a RuntimeException");
		doSomething();
		return null;
	}

	private void doSomething() {
		throw new RuntimeException("some thing error");
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
