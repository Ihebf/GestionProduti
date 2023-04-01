package com.vermeg.demo.controleurs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vermeg.demo.entities.Produit;
import com.vermeg.demo.service.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductControllerRestApi {

    private final IServiceProduit sp;

    @GetMapping("/all")
    public List<Produit> getAllProduct(){
        return sp.getAllProduit();
    }

    @GetMapping("/api/delete/{id}")
    public void deleteProduct(@PathVariable("id") Integer id){
        sp.deleteProduit(id);
    }

    @GetMapping(value = "/api/image/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable("id") Integer id) throws IOException {
        return sp.getImage(id);
    }

    @PostMapping("/ajouter")
    public void ajouterProduit(@RequestParam("produit") String produit, @RequestParam("file") MultipartFile mf) throws IOException {
        Produit p = new ObjectMapper().readValue(produit,Produit.class);
        sp.saveProduit(p,mf);

    }

}
