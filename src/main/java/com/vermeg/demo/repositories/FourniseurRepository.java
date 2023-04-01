package com.vermeg.demo.repositories;

import com.vermeg.demo.entities.Fourniseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FourniseurRepository extends JpaRepository<Fourniseur,Integer> {
}
