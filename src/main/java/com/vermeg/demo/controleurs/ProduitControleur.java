package com.vermeg.demo.controleurs;

import com.vermeg.demo.service.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ProduitControleur {

    private final IServiceProduit sp;

    @GetMapping("/home")
    public String getProducts(Model m, @RequestParam(name="mc",defaultValue = "") String mc){
        m.addAttribute("data",sp.getProduitBMC(mc));
        return "produits";
    }
}
