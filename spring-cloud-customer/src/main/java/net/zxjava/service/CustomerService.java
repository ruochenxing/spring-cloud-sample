package net.zxjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CustomerService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "error") // fallbackMethod 服务降级
	public String hello() {
		return restTemplate.getForEntity("http://SPRING-CLOUD-SERVICE/hello_3s", String.class).getBody();
	}

	public String error() { // add Throwable param to try exception
		return "error";
	}
}
