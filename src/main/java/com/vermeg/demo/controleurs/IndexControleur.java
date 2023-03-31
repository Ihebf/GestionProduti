package com.vermeg.demo.controleurs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControleur {

    @GetMapping(path = {"/", "/index"})
    public String getIndex() {
        return "Acceuil";
    }
}
