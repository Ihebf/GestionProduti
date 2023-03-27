package com.vermeg.demo.repositories;

import com.vermeg.demo.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Integer> {

    public List<Produit> findByNomContains(String mc);

    @Query("select p from Produit p where p.cat.id=:x")
    public List<Produit> getProduitByCat(@Param("x") Integer id);

}
