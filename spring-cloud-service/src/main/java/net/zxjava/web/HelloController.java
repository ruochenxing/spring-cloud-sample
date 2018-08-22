package net.zxjava.web;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private final Logger logger = Logger.getLogger(getClass());

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		logger.info("recv req");
		return "World";
	}

	// 模拟超时
	@RequestMapping(value = "/hello_3s", method = RequestMethod.GET)
	public String hello_3s() {
		int sleepTime = new Random().nextInt(3000);
		logger.info("hello service sleep " + sleepTime);
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("recv req");
		return "Hello World";
	}

	// 模拟异常
	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public String exception() throws Exception {
		throw new Exception("ops");
	}
}
