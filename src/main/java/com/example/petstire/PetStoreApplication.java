package com.example.petstire;

import com.example.petstire.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetStoreApplication{

	public static void main(String[] args) {
		SpringApplication.run(PetStoreApplication.class, args);
	}

}
