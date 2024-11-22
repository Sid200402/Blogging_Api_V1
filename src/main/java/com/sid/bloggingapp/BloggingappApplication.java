package com.sid.bloggingapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class BloggingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggingappApplication.class, args);
	}

	@Configuration
	public class ModelMapperConfig {

		@Bean
		public ModelMapper modelMapper() {

			return new ModelMapper();
		}
	}

}
