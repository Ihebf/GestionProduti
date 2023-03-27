package com.vermeg.demo.controleurs;

import com.vermeg.demo.service.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ProduitControleur {

    private final IServiceProduit sp;

    @GetMapping("/home")
    public String getAllProducts(Model m){
        m.addAttribute("data",sp.getAllProduit());
        return "produits";
    }
}
