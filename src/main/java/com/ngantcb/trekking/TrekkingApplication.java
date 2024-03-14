package com.ngantcb.trekking;

import com.ngantcb.trekking.entity.User;
import com.ngantcb.trekking.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class TrekkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrekkingApplication.class, args);
	}
	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(username -> {
				User user = new User();
				user.setUsername(username);
				user.setEmail(username.toLowerCase() + "@domain.com");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}
}
