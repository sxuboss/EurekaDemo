package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Value("${server.port}")
	private String port;

	@RequestMapping( value="/hi" ,method = RequestMethod.POST)
	public String home (@RequestParam String name){
		return "hi" + name + " i am from   port "+ port;

	}

}
