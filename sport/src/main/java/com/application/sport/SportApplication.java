package com.application.sport;

import com.application.sport.configuration.RabbitConfiguration;
import com.application.sport.configuration.WebSecurityConfig;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import({RabbitConfiguration.class, WebSecurityConfig.class})
@EnableRabbit
@EnableJpaRepositories
public class SportApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportApplication.class, args);
	}

}
