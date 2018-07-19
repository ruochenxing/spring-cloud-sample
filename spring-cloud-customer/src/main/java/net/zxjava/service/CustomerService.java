package net.zxjava.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("SPRING-CLOUD-SERVICE")
public interface CustomerService {
	
	@GetMapping("/hello")
	public String hello();
}
