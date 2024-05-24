/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.controllers;

import com.esgis.venteApiMaven.models.Categorie;
import com.esgis.venteApiMaven.services.CategorieService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/v1/categories")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;
    
    //POST http:localhost:8080/api/categories/new
    @PostMapping("/new")
    public Categorie createCategorie(@RequestBody Categorie categorie){
        return categorieService.create(categorie);
    }
    
    @GetMapping
    public List<Categorie> findAllCategorie(){
        return categorieService.findAll();
    }
    
    @GetMapping("/{id}")
    public Categorie findOneCategorie(@PathVariable String id){
        Optional<Categorie> categorie = categorieService.findById(id);
        
        if(categorie.isPresent()){
            return categorie.get();
        }
        return null;
    }
    
    @PutMapping("/update/{id}")
    public Categorie updateCategorie(@PathVariable String id, @RequestBody Categorie categorie){
        categorie.setId(id);
        return categorieService.update(categorie);        
    }
    
    //DELETE http:localhost:8080/api/categories/12
    @DeleteMapping("/delete/{id}")
    public String deleteCategorie(@PathVariable String id){
        Optional<Categorie> findById = categorieService.findById(id);
        if (findById.isPresent())
        {
            categorieService.delete(id);
            return "Categorie deleted !!!";
        }else
            return "Categorie not found !!!";
    }
    
    
}
