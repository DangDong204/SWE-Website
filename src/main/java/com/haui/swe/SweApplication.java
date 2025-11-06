package com.haui.swe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.haui.swe")
@EnableJpaRepositories(basePackages = "com.haui.swe.repository")
@EntityScan(basePackages = "com.haui.swe.model")
public class SweApplication {

	public static void main(String[] args) {

        SpringApplication.run(SweApplication.class, args);
	}

}
