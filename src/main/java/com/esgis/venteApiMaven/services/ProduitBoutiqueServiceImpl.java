/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.Boutique;
import com.esgis.venteApiMaven.models.ProduitBoutique;
import com.esgis.venteApiMaven.repositories.ProduitBoutiqueRepository;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aristide
 */
@Service
public class ProduitBoutiqueServiceImpl implements ProduitBoutiqueService{
    
    @Autowired
    private ProduitBoutiqueRepository produitBoutiqueRepository;
    
    public ProduitBoutique create(ProduitBoutique data){
        return produitBoutiqueRepository.save(data);
    }
    public ProduitBoutique update(ProduitBoutique data){
        return produitBoutiqueRepository.save(data);
    }
    public List<ProduitBoutique> findAll(){
        return produitBoutiqueRepository.findAll();
    }
    public Optional<ProduitBoutique> findById(String id){
        return produitBoutiqueRepository.findById(id);
    }
    public void delete(String id){
        produitBoutiqueRepository.deleteById(id);
    }
    
    public Optional<List<Boutique>>  findByBoutique(String boutiqueId){
        //return produitBoutiqueRepository.findByBoutique(boutiqueId);  
        ObjectId objectId = new ObjectId(boutiqueId);
        System.out.println("++ + + + + + + + ");
        System.out.println(boutiqueId);
        System.out.println(produitBoutiqueRepository.findByBoutique(objectId));
        System.out.println("++ + + + + + + + ");
        return produitBoutiqueRepository.findByBoutique(objectId);
    }
    public List<ProduitBoutique> findAllByBoutique(String boutiqueId){
        //return produitBoutiqueRepository.findByBoutique(boutiqueId);  
        ObjectId objectId = new ObjectId(boutiqueId);
        //System.out.println("++ + + + + + + + ");
        //System.out.println(boutiqueId);
        //System.out.println(produitBoutiqueRepository.findAllByBoutique(objectId));
        //System.out.println("++ + + + + + + + ");
        return produitBoutiqueRepository.findAllByBoutique(objectId);
    }
}

