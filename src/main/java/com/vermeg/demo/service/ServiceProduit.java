package com.vermeg.demo.service;

import com.vermeg.demo.entities.Produit;
import com.vermeg.demo.repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceProduit implements IServiceProduit {

    private final ProduitRepository pr;

    @Override
    public void saveProduit(Produit p) {
        pr.save(p);
    }

    @Override
    public List<Produit> getAllProduit() {
        return pr.findAll();
    }

    @Override
    public Page<Produit> getProduitBMC(String mc, Pageable p) {
        return pr.findByNomContains(mc,p);
    }


    @Override
    public List<Produit> getProduitByCat(Integer idcat) {
        return pr.getProduitByCat(idcat);
    }

    @Override
    public Produit getProduit(Integer id) {
        return pr.findById(id).orElse(null);
    }

    @Override
    public void deleteProduit(Integer id) {
        pr.deleteById(id);
    }
}
