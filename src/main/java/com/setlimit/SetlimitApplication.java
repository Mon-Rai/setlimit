package com.setlimit;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SetlimitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SetlimitApplication.class, args);
	}

	private ModelMapper modelMapper;

	@Bean
	public ModelMapper modelMapper(){
	return  new ModelMapper();
	}
}
