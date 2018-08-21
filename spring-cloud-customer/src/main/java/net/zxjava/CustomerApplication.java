package net.zxjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
// 两种服务调用方式，一种是ribbon+restTemplate（单实例只需要用restTemplate），另一种是feign
public class CustomerApplication {

	@Bean
	// @LoadBalanced // 开启客户端负载均衡
	public RestTemplate restTemplate() { // http client
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
}
