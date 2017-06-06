package com.adi.fileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Entry point to the program
 * @author aditya
 *
 */
@SpringBootApplication
@EnableScheduling
public class FileserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FileserviceApplication.class, args);
	}
}
