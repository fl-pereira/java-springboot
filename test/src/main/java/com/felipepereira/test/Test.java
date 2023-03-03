package com.felipepereira.test;

import com.felipepereira.test.entities.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class Test implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

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
