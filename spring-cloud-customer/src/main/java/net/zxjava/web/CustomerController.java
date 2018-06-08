package net.zxjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return restTemplate.getForEntity("http://SPRINT-CLOUD-SERVICE/hello", String.class).getBody();
	}
}
