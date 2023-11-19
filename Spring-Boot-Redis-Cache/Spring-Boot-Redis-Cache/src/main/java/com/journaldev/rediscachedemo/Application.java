package com.journaldev.rediscachedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Application implements CommandLineRunner {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;

	@Autowired
	public Application(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) {

		//Populating embedded database here
		LOG.info("Saving users. Current user count is {}.", userRepository.count());
		User user1 = new User("ayoub1", 2000);
		User user2 = new User("ayoub2", 29000);
		User user3 = new User("ayoub2", 550);

		user1.setUsername("ayoub1");
		user2.setUsername("ayoub2");
		user3.setUsername("ayoub3");
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		LOG.info("Done saving users. Data: {}.", userRepository.findAll());
	}
}
