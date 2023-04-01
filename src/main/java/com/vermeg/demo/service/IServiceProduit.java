package com.vermeg.demo.service;

import com.vermeg.demo.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IServiceProduit {
    void saveProduit(Produit p, MultipartFile mf) throws IOException;
    List<Produit> getAllProduit();
    Page<Produit> getProduitBMC(String mc, Pageable p);
    List <Produit> getProduitByCat(Integer idcat);
    Produit getProduit(Integer id);
    void deleteProduit (Integer id);
    byte[] getImage(Integer id) throws IOException;


}
