package com.felipepereira.springboot.resources;

import com.felipepereira.springboot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        //List<User> list = service.findAll();
        User u = new User(1L,"Felipe Pereira","mail@mail.com","4399990000","123456");
        return ResponseEntity.ok().body(u);
    }
}
