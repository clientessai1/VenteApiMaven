/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.Boutique;
import com.esgis.venteApiMaven.models.ProduitBoutique;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

/**
 *
 * @author aristide
 */
@Service
public interface ProduitBoutiqueService {
    
    public ProduitBoutique create(ProduitBoutique data);
    public ProduitBoutique update(ProduitBoutique data);
    public List<ProduitBoutique> findAll();
    public List<ProduitBoutique> findAllByBoutique(String boutiqueId);
    public Optional <ProduitBoutique> findById(String id);
    public void delete(String id);
        public Optional<List<Boutique>>  findByBoutique(String boutiqueId);
}

