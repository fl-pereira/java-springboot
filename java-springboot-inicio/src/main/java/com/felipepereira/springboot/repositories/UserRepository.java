package com.felipepereira.springboot.repositories;

import com.felipepereira.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
