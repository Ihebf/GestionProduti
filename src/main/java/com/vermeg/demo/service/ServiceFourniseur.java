package com.vermeg.demo.service;

import com.vermeg.demo.entities.Fourniseur;
import com.vermeg.demo.repositories.FourniseurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceFourniseur implements IServiceFourniseur{

    private final FourniseurRepository fr;


    @Override
    public void saveFourniseur(Fourniseur p) {
        fr.save(p);
    }

    @Override
    public List<Fourniseur> getAllFourniseur() {
        return fr.findAll();
    }

    @Override
    public Fourniseur getFourniseur(Integer id) {
        return fr.findById(id).orElse(null);
    }

    @Override
    public void deleteFourniseur(Integer id) {
        fr.deleteById(id);
    }
}
