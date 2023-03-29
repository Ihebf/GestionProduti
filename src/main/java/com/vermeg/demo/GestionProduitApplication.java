package com.vermeg.demo;

import com.vermeg.demo.entities.Categorie;
import com.vermeg.demo.entities.Produit;
import com.vermeg.demo.repositories.CategorieRepository;
import com.vermeg.demo.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionProduitApplication implements CommandLineRunner {

    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    CategorieRepository categorieRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionProduitApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        for (int i=0;i<10;i++){
            Categorie c1 = new Categorie(null,"Informatique",null);
            Categorie c2 = new Categorie(null,"Bureatique",null);
            Categorie c3 = new Categorie(null,"Electronique",null);
            categorieRepository.save(c1);
            categorieRepository.save(c2);
            categorieRepository.save(c3);

            Produit p1 = new Produit(null,"PC"+i,2000d,5,categorieRepository.findById(1).get(),null);
            Produit p2 = new Produit(null,"Souris"+i,3000d,5,categorieRepository.findById(1).get(),null);
            Produit p3 = new Produit(null,"Clavier"+i,4000d,5,categorieRepository.findById(1).get(),null);
            Produit p4 = new Produit(null,"Ecran"+i,2000,5,categorieRepository.findById(1).get(),null);
            Produit p5 = new Produit(null,"TV"+i,2000d,5,categorieRepository.findById(1).get(),null);
            produitRepository.save(p1);
            produitRepository.save(p2);
            produitRepository.save(p3);
            produitRepository.save(p4);
            produitRepository.save(p5);
        }

    }


}
