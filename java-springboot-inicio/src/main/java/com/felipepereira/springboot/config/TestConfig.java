package com.felipepereira.springboot.config;

import com.felipepereira.springboot.entities.Order;
import com.felipepereira.springboot.entities.User;
import com.felipepereira.springboot.repositories.OrderRepository;
import com.felipepereira.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Felipe Pereira","mail@mail.com","43999510000","123abc");
        User u2 = new User(null,"Daphne Correa","mail@mail.com","43999510000","abc123");
        User u3 = new User(null,"Gatas","mail@mail.com","43999510000","123456");

        Order o1 = new Order(null, Instant.parse("2022-12-12T08:59:32Z"), u1);
        Order o2 = new Order(null, Instant.parse("2022-04-11T05:44:51Z"), u3);
        Order o3 = new Order(null, Instant.parse("2022-07-05T12:55:43Z"), u2);
        Order o4 = new Order(null, Instant.parse("2022-10-07T01:12:05Z"), u1);
        Order o5 = new Order(null, Instant.parse("2022-11-08T09:35:11Z"), u3);

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));
    }
}
