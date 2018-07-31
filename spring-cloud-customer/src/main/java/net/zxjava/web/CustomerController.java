package net.zxjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.zxjava.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/index")
	public String index() {
		return customerService.hello();
	}

	@RequestMapping("/hello_3s")
	public String hello3s() {
		return customerService.hello3s();
	}

	@RequestMapping("/exception")
	public String exception() {
		return customerService.exception();
	}
}
