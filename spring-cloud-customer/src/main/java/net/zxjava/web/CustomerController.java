package net.zxjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.zxjava.api.User;
import net.zxjava.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return customerService.hello();
	}

	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String index2() {
		StringBuilder sb = new StringBuilder();
		sb.append(customerService.hello()).append("\n");
		sb.append(customerService.user("John")).append("\n");
		sb.append(customerService.getUser(1234)).append("\n");
		User user = new User();
		user.setAge(1);
		user.setName("Tom");
		sb.append(customerService.createUser(user)).append("\n");
		return sb.toString();
	}
}
