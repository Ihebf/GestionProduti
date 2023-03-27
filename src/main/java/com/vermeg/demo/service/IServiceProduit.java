package com.vermeg.demo.service;

import com.vermeg.demo.entities.Produit;
import java.util.List;

public interface IServiceProduit {
    void saveProduit(Produit p);
    List<Produit> getAllProduit();
    List<Produit> getProduitBMC(String mc);
    List <Produit> getProduitByCat(Integer idcat);
    Produit getProduit(Integer id);
    void deleteProduit (Integer id);


}
