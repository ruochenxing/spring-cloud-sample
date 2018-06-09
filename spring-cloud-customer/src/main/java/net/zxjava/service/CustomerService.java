package net.zxjava.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.zxjava.api.User;

/**
 * feign = ribbon + hystrix
 * 
 * 对应spring-cloud-service的接口 这个接口应该和user类一样，被扔到一个单独的maven项目中，当作spring-cloud-service-api
 */
@FeignClient("sprint-cloud-service")
public interface CustomerService {

	@RequestMapping("/hello")
	public String hello();

	// http://xxxxx?name=xxxxxx
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(@RequestParam(value = "name", required = true) String name);

	// http://xxxxx/1111 id=1111
	@RequestMapping(value = "/{uid}", method = RequestMethod.GET)
	public String getUser(@PathVariable("uid") Integer id);

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(@RequestBody User user);
}
