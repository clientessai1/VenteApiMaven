/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.DetailApprovisionnement;
import com.esgis.venteApiMaven.models.DetailVente;
import com.esgis.venteApiMaven.repositories.DetailVenteRepository;
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
public class DetailVenteServiceImpl implements DetailVenteService{
    
    @Autowired
    private DetailVenteRepository detailVenteRepository;
    
    public DetailVente create(DetailVente data){
        return detailVenteRepository.save(data);
    }
    public DetailVente update(DetailVente data){
        return detailVenteRepository.save(data);
    }
    public List<DetailVente> findAll(){
        return detailVenteRepository.findAll();
    }
    public Optional<DetailVente> findById(String id){
        return detailVenteRepository.findById(id);
    }
    public void delete(String id){
        detailVenteRepository.deleteById(id);
    }
    

    public List<DetailVente> findAllByVente(String venteId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ObjectId objectId = new ObjectId(venteId);
        System.out.println("++ + + + + + + + ");
        System.out.println(venteId);
        System.out.println(detailVenteRepository.findAllByVente(objectId));
        System.out.println("++ + + + + + + + ");        
        return detailVenteRepository.findAllByVente(objectId);
    }
          
    
}

