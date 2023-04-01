package com.vermeg.demo.controleurs;

import com.vermeg.demo.entities.Produit;
import com.vermeg.demo.service.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
