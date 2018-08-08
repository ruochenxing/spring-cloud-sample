package net.zxjava.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
public class ErrorHandlerController implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	public String error() {
		return "出现异常";
	}

}
