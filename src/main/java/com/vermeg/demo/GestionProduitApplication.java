package com.vermeg.demo;

import com.vermeg.demo.entities.AppRole;
import com.vermeg.demo.entities.AppUser;
import com.vermeg.demo.entities.Categorie;
import com.vermeg.demo.entities.Produit;
import com.vermeg.demo.repositories.CategorieRepository;
import com.vermeg.demo.repositories.ProduitRepository;
import com.vermeg.demo.repositories.RoleRepository;
import com.vermeg.demo.repositories.UserRepository;
import com.vermeg.demo.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class GestionProduitApplication implements CommandLineRunner {

    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

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

        AppRole role1 = new AppRole();
        AppRole role2 = new AppRole();

        role1.setRole("USER");
        role2.setRole("ADMIN");

        ArrayList<AppRole> roles1 = new ArrayList<>();
        roles1.add(role1);

        ArrayList<AppRole> roles2 = new ArrayList<>();
        roles2.add(role2);



        AppUser user1 = new AppUser();
        AppUser user2 = new AppUser();

        user1.setUsername("user1");
        user1.setPassword("123");
        user1.setRoles(roles1);

        user1.setUsername("admin");
        user1.setPassword("123");
        user1.setRoles(roles2);

        userRepository.save(user1);
        userRepository.save(user2);
        roleRepository.save(role1);
        roleRepository.save(role2);

    }


}
