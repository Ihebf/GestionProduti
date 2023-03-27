package com.vermeg.demo.service;

import com.vermeg.demo.entities.Categorie;
import com.vermeg.demo.repositories.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceCategorie implements IServiceCategorie{

    private final CategorieRepository cr;

    @Override
    public void addCategorie(Categorie c) {
        cr.save(c);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return cr.findAll();
    }
}
