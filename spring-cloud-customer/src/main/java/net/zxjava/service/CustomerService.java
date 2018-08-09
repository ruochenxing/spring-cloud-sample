package net.zxjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

//@Service
public class CustomerService {

	@Autowired
	private RestTemplate restTemplate; // spring http client

	public String index() {
		return restTemplate.getForEntity("http://SPRING-CLOUD-SERVICE/hello", String.class).getBody();
	}
}
