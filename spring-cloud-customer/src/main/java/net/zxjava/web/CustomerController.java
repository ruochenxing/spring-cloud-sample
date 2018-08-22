package net.zxjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.zxjava.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/index_3s", method = RequestMethod.GET)
	public String index() {
		return customerService.hello_3s();
	}
	
	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public String exception() {
		return customerService.exception();
	}
	
	@RequestMapping(value = "/exceptionByMyself", method = RequestMethod.GET)
	public String exceptionByMyself() {
		return customerService.exceptionByMyself();
	}
}
