package net.zxjava.service;

import org.springframework.stereotype.Component;

@Component
public class CustomerServiceFallback implements CustomerService {

	@Override
	public String hello() {
		return "error hello";
	}

	@Override
	public String user(String name) {
		return null;
	}

	@Override
	public String getUser(Integer id) {
		return null;
	}

	@Override
	public String createUser(Object user) {
		return null;
	}

	@Override
	public String hello3s() {
		return "error hello3s";
	}

	@Override
	public String exception() {
		return "ops";
	}

}
