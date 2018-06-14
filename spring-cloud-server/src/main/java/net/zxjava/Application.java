package net.zxjava;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// java -jar target/spring-cloud-server-1.0-RELEASE.jar --spring.profiles.active=slave1
@SpringBootApplication
@EnableEurekaServer
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

}