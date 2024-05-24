/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.controllers;

import com.esgis.venteApiMaven.models.Produit;
import com.esgis.venteApiMaven.services.ProduitService;
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
@RequestMapping("/api/v1/produits")
public class ProduitController {
    
    @Autowired
    private ProduitService produitService;

    @PostMapping("/new")
    public Produit create(@RequestBody Produit produit) {
        return produitService.create(produit);
    }

    @GetMapping
    public List<Produit> findAllProduits() {
        return produitService.findAll();
    }

    @GetMapping("/{id}")
    public Produit findOneProduits(@PathVariable String id) {
        Optional<Produit> produit = produitService.findById(id);
        if (produit.isPresent()) {
            return produit.get();
        }
        return null;
    }

    //DELETE http:localhost:8080/api/produits/update/12
    @PutMapping("/update/{id}")
    public Produit updateProduit(@PathVariable String id, @RequestBody Produit produit) {
        produit.setId(id);
        return produitService.update(produit);
    }

    //DELETE http:localhost:8080/api/produits/delete/12
    @DeleteMapping("/delete/{id}")
    public String deleteProduit(@PathVariable String id) {
        Optional<Produit> findById = produitService.findById(id);
        if (findById.isPresent())
        {
            produitService.delete(id);
            return "Product deleted !!!";
        }else
            return "Product not found !!!";
    }


}
