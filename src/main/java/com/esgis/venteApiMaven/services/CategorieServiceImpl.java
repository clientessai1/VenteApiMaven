/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.Categorie;
import com.esgis.venteApiMaven.repositories.CategorieRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aristide
 */
@Service
public class CategorieServiceImpl implements CategorieService{
    
    @Autowired
    private CategorieRepository categorieRepository;
    
    public Categorie create(Categorie data){
        return categorieRepository.save(data);
    }
    public Categorie update(Categorie data){
        return categorieRepository.save(data);
    }
    public List<Categorie> findAll(){
        return categorieRepository.findAll();
    }
    public Optional<Categorie> findById(String id){
        return categorieRepository.findById(id);
    }
    public void delete(String id){
        categorieRepository.deleteById(id);
    }
}

