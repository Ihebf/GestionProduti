package com.vermeg.demo.service;

import com.vermeg.demo.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceProduit {
    void saveProduit(Produit p);
    List<Produit> getAllProduit();
    Page<Produit> getProduitBMC(String mc, Pageable p);
    List <Produit> getProduitByCat(Integer idcat);
    Produit getProduit(Integer id);
    void deleteProduit (Integer id);


}
