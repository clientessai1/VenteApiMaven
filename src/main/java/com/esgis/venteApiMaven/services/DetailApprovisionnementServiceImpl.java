/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.DetailApprovisionnement;
import com.esgis.venteApiMaven.models.ProduitBoutique;
import com.esgis.venteApiMaven.repositories.DetailApprovisionnementRepository;
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
public class DetailApprovisionnementServiceImpl implements DetailApprovisionnementService{
    
    @Autowired
    private DetailApprovisionnementRepository detailApproRepository;
    
    public DetailApprovisionnement create(DetailApprovisionnement data){
        return detailApproRepository.save(data);
    }
    public DetailApprovisionnement update(DetailApprovisionnement data){
        return detailApproRepository.save(data);
    }
    public List<DetailApprovisionnement> findAll(){
        return detailApproRepository.findAll();
    }
    public Optional<DetailApprovisionnement> findById(String id){
        return detailApproRepository.findById(id);
    }
    public void delete(String id){
        detailApproRepository.deleteById(id);
    }

    public List<DetailApprovisionnement> findAllByProduitBoutiqueId(String produitBoutiqueId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ObjectId objectId = new ObjectId(produitBoutiqueId);
        System.out.println("++ + + + + + + + ");
        System.out.println(produitBoutiqueId);
        System.out.println(detailApproRepository.findAllByProduitBoutiqueId(objectId));
        System.out.println("++ + + + + + + + ");        
        return detailApproRepository.findAllByProduitBoutiqueId(objectId);
    }
        
}

