package com.example.petstire;

import com.example.petstire.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetStireApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PetStireApplication.class, args);
	}

	@Autowired
	private IUserService userService;


	@Override
	public void run(String... args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
}
