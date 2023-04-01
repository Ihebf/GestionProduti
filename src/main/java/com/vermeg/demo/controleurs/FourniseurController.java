package com.vermeg.demo.controleurs;

import com.vermeg.demo.service.IServiceFourniseur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class FourniseurController {

    private final IServiceFourniseur sf;

    @GetMapping("/fourniseurs")
    public String getFourniseurs(Model m){
        m.addAttribute("data",sf.getAllFourniseur());
        return "fourniseurs";
    }

    @GetMapping("/fourniseurs/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        sf.deleteFourniseur(id);
        return "redirect:/fourniseurs";
    }

    @GetMapping("/fourniseurs/produits/{id}")
    public String getForuniseurProduits(Model m,@PathVariable("id") Integer id){
        m.addAttribute("data",sf.getFourniseur(id).getProduits());
        return "fproduit";
    }
}
