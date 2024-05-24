/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.Boutique;
import com.esgis.venteApiMaven.repositories.BoutiqueRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aristide
 */
@Service
public class BoutiqueServiceImpl implements BoutiqueService{
    
    @Autowired
    private BoutiqueRepository boutiqueRepository;
    
    public Boutique create(Boutique data){
        return boutiqueRepository.save(data);
    }
    public Boutique update(Boutique data){
        return boutiqueRepository.save(data);
    }
    public List<Boutique> findAll(){
        return boutiqueRepository.findAll();
    }
    public Optional<Boutique> findById(String id){
        return boutiqueRepository.findById(id);
    }
    public void delete(String id){
        boutiqueRepository.deleteById(id);
    }
}

