package Actividad4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class ActTraninig1Application {

	public static void main(String[] args) {
		SpringApplication.run(ActTraninig1Application.class, args);
	}

}
