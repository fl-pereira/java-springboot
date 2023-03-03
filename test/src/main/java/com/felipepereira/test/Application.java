package com.felipepereira.test;

import com.felipepereira.test.entities.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		RestTemplate template = new RestTemplate();

		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("my-json-server.typicode.com/")
				.path("fdiogoc/probable-eureka/coupons")
				.queryParam("fields", "all")
				.build();

		ResponseEntity<Person> entity = template.getForEntity(uri.toString(), Person.class);
		System.out.println(entity.getBody().getName());
	}

}
