package com.vermeg.demo.service;

import com.vermeg.demo.entities.Fourniseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IServiceFourniseur {
    void saveFourniseur(Fourniseur p);
    List<Fourniseur> getAllFourniseur();
    Fourniseur getFourniseur(Integer id);
    void deleteFourniseur (Integer id);
}
