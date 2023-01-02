package com.felipepereira.springboot.config;

import com.felipepereira.springboot.entities.Category;
import com.felipepereira.springboot.entities.Order;
import com.felipepereira.springboot.entities.Product;
import com.felipepereira.springboot.entities.User;
import com.felipepereira.springboot.entities.enums.OrderStatus;
import com.felipepereira.springboot.repositories.CategoryRepository;
import com.felipepereira.springboot.repositories.OrderRepository;
import com.felipepereira.springboot.repositories.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category ct1 = new Category(null, "Eletronics");
        Category ct2 = new Category(null, "Books");
        Category ct3 = new Category(null, "Computers");

        Product prod1 = new Product(null,"Computer Celeron","Computer Celeron with 500gb Hard Disk", 259.00, "");
        Product prod2 = new Product(null,"Harry Potter","Harry Potter and the Philosophal Stone", 29.00, "");
        Product prod3 = new Product(null,"TV 40 Plasma","Plasma TV with 40", 105.00, "");
        Product prod4 = new Product(null,"Mouse Knup","Wireless mouse for PC", 25.00, "");
        Product prod5 = new Product(null,"Avengers","A book of Avengers", 19.95, "");

        User u1 = new User(null,"Felipe Pereira","mail@mail.com","43999510000","123abc");
        User u2 = new User(null,"Daphne Correa","mail@mail.com","43999510000","abc123");
        User u3 = new User(null,"Gatas","mail@mail.com","43999510000","123456");

        Order o1 = new Order(null, Instant.parse("2022-12-12T08:59:32Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2022-04-11T05:44:51Z"), OrderStatus.CANCELED, u3);
        Order o3 = new Order(null, Instant.parse("2022-07-05T12:55:43Z"), OrderStatus.DELIVERED, u2);
        Order o4 = new Order(null, Instant.parse("2022-10-07T01:12:05Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o5 = new Order(null, Instant.parse("2022-11-08T09:35:11Z"), OrderStatus.SHIPPED, u3);

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));
        categoryRepository.saveAll(Arrays.asList(ct1,ct2,ct3));
        productRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5));
    }
}
