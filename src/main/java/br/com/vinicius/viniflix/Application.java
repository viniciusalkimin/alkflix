package br.com.vinicius.viniflix;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import javax.persistence.Cacheable;

@Cacheable
@SpringBootApplication
@EnableSpringDataWebSupport
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
