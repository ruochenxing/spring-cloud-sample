package net.zxjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CustomerService {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Hystrix默认超时时间是2s
	 */
	@HystrixCommand(fallbackMethod = "error") // fallbackMethod 服务降级
	public String hello() {
		// 他不回你的短信
		return restTemplate.getForEntity("http://SPRING-CLOUD-SERVICE/hello_3s", String.class).getBody();
	}

	@HystrixCommand(fallbackMethod = "exception")
	public String exception() {
		// 他收到短信就死了
		return restTemplate.getForEntity("http://SPRING-CLOUD-SERVICE/exception", String.class).getBody();
	}

	@HystrixCommand(fallbackMethod = "exception")
	public String exceptionByMyself() {
		// 你生病了
		System.out.println(1 / 0);
		return restTemplate.getForEntity("http://SPRING-CLOUD-SERVICE/hello", String.class).getBody();
	}

	public String error() {
		return "error";
	}

	public String exception(Throwable e) { // add Throwable param to try exception
		System.out.println(e.getMessage());
		return "exception";
	}
}
