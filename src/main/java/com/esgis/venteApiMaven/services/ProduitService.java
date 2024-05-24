/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.Boutique;
import com.esgis.venteApiMaven.models.Produit;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author aristide
 */
public interface ProduitService {
        
    public Produit create(Produit data);
    
    public Produit update(Produit data);
    
    public List<Produit> findAll();
    
    public Optional<Produit> findById(String id);
    
    public void delete(String id);
    


}
