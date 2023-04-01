package com.vermeg.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

import com.sun.istack.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NotNull @Size(min = 2, max = 30) // @Pattern(regexp = "^[A-Z].*", message = "Le nom du produit doit etre en Majuscule")
    private String nom;
    @Min(0)
    private double prix;
    @Min(0)
    private int quantitie;
    @ManyToOne
    private Categorie cat;
    private String photo;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Fourniseur> fourniseurs;
}