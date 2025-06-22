package client.apis.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = {
		"client.apis",
		"logic.layer",
		"data.layer",
		"models"
})
public class Runner {	
	public static void main(String[] args) throws ClassNotFoundException {
		SpringApplication.run(Runner.class, args);
	}
}

