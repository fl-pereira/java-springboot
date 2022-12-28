package com.felipepereira.springboot.config;

import com.felipepereira.springboot.entities.User;
import com.felipepereira.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Felipe Pereira","mail@mail.com","43999510000","123abc");
        User u2 = new User(null,"Daphne Correa","mail@mail.com","43999510000","abc123");
        User u3 = new User(null,"Gatas","mail@mail.com","43999510000","123456");

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
    }
}
