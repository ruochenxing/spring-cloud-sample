package net.zxjava.web;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.zxjava.api.User;

@RestController
public class HelloController {

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient client;

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
		return "Hello World";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/hello_3s", method = RequestMethod.GET)
	public String hello_3s() {
		int sleepTime = new Random().nextInt(3000);
		logger.info("hello service sleep " + sleepTime);
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
		return "Hello World";
	}

	/************************* feign参数 ***********************/

	// http://xxxxx?name=xxxxxx
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(@RequestParam(value = "name", required = true) String name) {
		return "Hello " + name;
	}

	// http://xxxxx/1111 id=1111
	@RequestMapping(value = "/{uid}", method = RequestMethod.GET)
	public String getUser(@PathVariable("uid") Integer id) {
		return "user " + id;
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(@RequestBody User user) {
		return "success";
	}
}
