package com.vermeg.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private double prix;
    private int quantitie;
    @ManyToOne
    private Categorie cat;
}
