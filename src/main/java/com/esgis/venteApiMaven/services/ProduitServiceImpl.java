/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.Boutique;
import com.esgis.venteApiMaven.models.Produit;
import com.esgis.venteApiMaven.repositories.ProduitRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aristide
 */

@Service
public class ProduitServiceImpl implements ProduitService{
    
    @Autowired
    private ProduitRepository produitRepository;
    
    public Produit create(Produit data){
        return produitRepository.save(data);
    }
    
    public Produit update(Produit data){
        return produitRepository.save(data);
    }
    
    public List<Produit> findAll(){
        return produitRepository.findAll();
    }
    
    public Optional<Produit> findById(String id){
        return produitRepository.findById(id);
    }
    
    public void delete(String id){
        produitRepository.deleteById(id);
    }


    
}
