package com.ayush.userservice;

import com.ayush.userservice.entity.User;
import com.ayush.userservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class UserServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Autowired
	private UserRepo userRepo;

	@Override
	public void run(String... args) throws Exception {
		userRepo.save(User.builder().email("admin@gmail.com").password("$2a$12$EWEM2Nes6vYx1f/1XM0ai.yFMf3ysHuZK1RqzDNj5Z1.9tQ2.Wi1y").build());
	}
}
