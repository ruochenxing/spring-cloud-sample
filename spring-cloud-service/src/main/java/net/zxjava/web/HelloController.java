package net.zxjava.web;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
