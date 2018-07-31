package net.zxjava.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("SPRING-CLOUD-SERVICE")
public interface CustomerService {

	@RequestMapping("/hello")
	public String hello();

	// http://xxxxx?name=xxxxxx
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(@RequestParam(value = "name", required = true) String name);

	// http://xxxxx/1111 id=1111
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable("id") Integer id);

	// post json
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(@RequestBody Object user);
}
