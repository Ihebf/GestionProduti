package com.vermeg.demo.service;

import com.vermeg.demo.entities.Produit;
import com.vermeg.demo.repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceProduit implements IServiceProduit {

    private final ProduitRepository pr;

    @Override
    public void saveProduit(Produit p, MultipartFile mf) throws IOException {
        if(!mf.isEmpty()){
            String i = saveImage1(mf);
            p.setPhoto(i);
        }

        pr.save(p);

        List<Produit> l = pr.findAll();
    }

    @Override
    public List<Produit> getAllProduit() {
        return pr.findAll();
    }

    @Override
    public Page<Produit> getProduitBMC(String mc, Pageable p) {
        return pr.findByNomContains(mc,p);
    }


    @Override
    public List<Produit> getProduitByCat(Integer idcat) {
        return pr.getProduitByCat(idcat);
    }

    @Override
    public Produit getProduit(Integer id) {
        return pr.findById(id).orElse(null);
    }

    @Override
    public void deleteProduit(Integer id) {
        pr.deleteById(id);
    }

    @Override
    public byte[] getImage(Integer id) throws IOException {
        String path = System.getProperty("user.home") + "/photos/";
        Path p = Paths.get(path,pr.getReferenceById(id).getPhoto());

        return Files.readAllBytes(p);
    }

    private String saveImage(MultipartFile mf) throws IOException {
        String nomFile = mf.getOriginalFilename();
        String tab[] = nomFile.split("\\.");
        String newName = tab[0] + System.currentTimeMillis() + "." + tab[1];
        Path p = Paths.get(System.getProperty("user.dir") + "/src/main/resources/photo/",newName);
        Files.write(p,mf.getBytes());
        return newName;
    }
    private String saveImage1(MultipartFile mf) throws IOException {
        String nomFile = mf.getOriginalFilename();
        String[] tab = nomFile.split("\\.");
        String newName = tab[0] + System.currentTimeMillis() + "." + tab[1];
        String path = System.getProperty("user.home") + "/photos/";
        if(Files.notExists(Paths.get(path))){
            Files.createDirectories(Paths.get(path));
        }
        Path p = Paths.get(path,newName);
        Files.write(p,mf.getBytes());
        return newName;
    }
}
