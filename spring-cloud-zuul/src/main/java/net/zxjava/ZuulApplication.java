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

//	@Bean
//	public PatternServiceRouteMapper serviceRouteMapper() {
//		return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
//	}
}
