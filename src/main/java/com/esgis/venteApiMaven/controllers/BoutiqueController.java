/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.controllers;

import com.esgis.venteApiMaven.models.Boutique;
import com.esgis.venteApiMaven.models.Produit;
import com.esgis.venteApiMaven.repositories.BoutiqueRepository;
import com.esgis.venteApiMaven.repositories.ProduitRepository;
import com.esgis.venteApiMaven.services.BoutiqueService;
import com.esgis.venteApiMaven.services.ProduitBoutiqueService;
import com.esgis.venteApiMaven.services.ProduitService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aristide
 */
@RestController
@RequestMapping("/api/v1/boutiques")
public class BoutiqueController {
    @Autowired
    private BoutiqueService boutiqueService;
        
    //POST http:localhost:8080/api/boutiques/new
    @PostMapping("/new")
    public Boutique createBoutique(@RequestBody Boutique boutique){
        return boutiqueService.create(boutique);
    }
    
    @GetMapping
    public List<Boutique> findAllBoutique(){
        return boutiqueService.findAll();
    }
    
    @GetMapping("/{id}")
    public Boutique findOneBoutique(@PathVariable String id){
        Optional<Boutique> boutique = boutiqueService.findById(id);
        
        if(boutique.isPresent()){
            return boutique.get();
        }
        return null;
    }

    
    @PutMapping("/update/{id}")
    public Boutique updateBoutique(@PathVariable String id, @RequestBody Boutique boutique){
        boutique.setId(id);
        return boutiqueService.update(boutique);        
    }
    
    //DELETE http:localhost:8080/api/boutiques/delete/12
    @DeleteMapping("/delete/{id}")
    public String deleteBoutique(@PathVariable String id){

        Optional<Boutique> findById = boutiqueService.findById(id);
        if (findById.isPresent())
        {
            boutiqueService.delete(id);
            return "Boutique deleted !!!";
            //return true;
        }else
            return "Boutique not found !!!";        
            //return false;
        
    }
    
    
}
