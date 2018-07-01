package net.zxjava.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "success";
	}
	
	
	@RequestMapping(value = "/local/hello", method = RequestMethod.GET)
	public String hello() {
		return "/local/hello success";
	}
}
