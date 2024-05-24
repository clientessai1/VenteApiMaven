/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.Categorie;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author aristide
 */
@Service
public interface CategorieService {
    /*
        public Optional<Categorie> create(Categorie data);
    public Optional<Categorie> update(Categorie data);
    public List<Categorie> findAll();
    public Optional<Categorie> findById(String id);
    public void delete(String id);
    */
    
    public Categorie create(Categorie data);
    public Categorie update(Categorie data);
    public List<Categorie> findAll();
    public Optional <Categorie> findById(String id);
    public void delete(String id);
}

