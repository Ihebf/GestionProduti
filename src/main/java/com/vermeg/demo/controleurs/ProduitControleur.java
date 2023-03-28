package com.vermeg.demo.controleurs;

import com.vermeg.demo.entities.Produit;
import com.vermeg.demo.service.IServiceCategorie;
import com.vermeg.demo.service.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ProduitControleur {

    private final IServiceProduit sp;
    private final IServiceCategorie sc;

    @GetMapping("/home")
    public String getProducts(Model m, @RequestParam(name="mc",defaultValue = "") String mc){
        m.addAttribute("data",sp.getProduitBMC(mc));
        m.addAttribute("mc",mc);
        return "produits";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        sp.deleteProduit(id);
        return "redirect:/home";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model m){
        m.addAttribute("data", new Produit());
        m.addAttribute("categories",sc.getAllCategories());
        return "addProduct";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Produit produit){
        sp.saveProduit(produit);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id,Model m){
        Produit product = sp.getProduit(id);
        m.addAttribute("data", product);
        m.addAttribute("categories",sc.getAllCategories());
        return "addProduct";
    }
}
