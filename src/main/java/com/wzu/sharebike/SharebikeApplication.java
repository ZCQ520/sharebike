package com.wzu.sharebike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext-*.xml")
public class SharebikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharebikeApplication.class, args);
	}
}
