package net.zxjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("SPRING-CLOUD-SERVICE");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello";
		System.out.println(url);
		return restTemplate.getForEntity(url, String.class).getBody();
		// @LoadBalanced 开启客户端负载均衡
		// return restTemplate.getForEntity("http://SPRING-CLOUD-SERVICE/hello", String.class).getBody();
	}
}
