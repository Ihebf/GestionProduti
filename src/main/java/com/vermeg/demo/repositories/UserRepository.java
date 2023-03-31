package com.vermeg.demo.repositories;

import com.vermeg.demo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Integer> {

    AppUser findByUsername(String username);

}
