/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.Vente;
import com.esgis.venteApiMaven.repositories.VenteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aristide
 */
@Service
public class VenteServiceImpl implements VenteService{
    
    @Autowired
    private VenteRepository categorieRepository;
    
    public Vente create(Vente data){
        return categorieRepository.save(data);
    }
    public Vente update(Vente data){
        return categorieRepository.save(data);
    }
    public List<Vente> findAll(){
        return categorieRepository.findAll();
    }
    public Optional<Vente> findById(String id){
        return categorieRepository.findById(id);
    }
    public void delete(String id){
        categorieRepository.deleteById(id);
    }
}

