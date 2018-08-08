package net.zxjava;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {
	public static void main(String[] args) {
		// FilterProcessor.setProcessor(new MyFilterProcessor());
		new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
	}

	// @Bean
	// public AccessFilter accessFilter() {
	// return new AccessFilter();
	// }
	//
	// @Bean
	// public ThrowExceptionFilter throwExceptionFilter() {
	// return new ThrowExceptionFilter();
	// }
	//
	// @Bean
	// public ErrorFilter errorFilter() {
	// return new ErrorFilter();
	// }
}
