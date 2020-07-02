package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {


	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new UserEntity("Jack"));
			repository.save(new UserEntity("Adam"));
			repository.save(new UserEntity("Nick"));
			repository.save(new UserEntity("Tony"));

			// fetch all customers
			log.info("User found with findAll():");
			log.info("-------------------------------");
			for (UserEntity customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			UserEntity customer = repository.findById(1L);
			log.info("UserEntity found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByName("Jack").forEach(bauer -> {
				log.info(bauer.toString());
			});

			log.info("");
		};
	}


}
