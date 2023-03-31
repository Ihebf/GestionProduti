package com.vermeg.demo.repositories;

import com.vermeg.demo.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole,Integer> {
}
