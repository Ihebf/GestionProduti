package com.vermeg.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fourniseur {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    @ManyToMany(mappedBy = "fourniseurs", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    List<Produit> produits;
}
