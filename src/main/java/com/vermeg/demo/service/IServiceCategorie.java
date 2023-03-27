package com.vermeg.demo.service;

import com.vermeg.demo.entities.Categorie;

import java.util.List;

public interface IServiceCategorie {

    void addCategorie(Categorie c);
    List<Categorie> getAllCategories();
}
