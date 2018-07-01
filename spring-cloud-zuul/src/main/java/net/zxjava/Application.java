package net.zxjava;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.netflix.zuul.FilterProcessor;

import net.zxjava.ext.MyFilterProcessor;
import net.zxjava.filter.AccessFilter;
import net.zxjava.filter.ErrorFilter;
import net.zxjava.filter.ThrowExceptionFilter;

@EnableZuulProxy
@SpringCloudApplication
public class Application {
	public static void main(String[] args) {
		FilterProcessor.setProcessor(new MyFilterProcessor());
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}

	@Bean
	public ThrowExceptionFilter throwExceptionFilter() {
		return new ThrowExceptionFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
}
