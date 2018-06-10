package net.zxjava.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class IndexController {

	@Value("${from}")
	private String from;

	@RequestMapping(value = "/from")
	public String from() {
		return this.from;
	}
}
