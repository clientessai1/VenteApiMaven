/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.Approvisionnement;
import com.esgis.venteApiMaven.repositories.ApprovisionnementRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aristide
 */
@Service
public class ApprovisionnementServiceImpl implements ApprovisionnementService{
    
    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;
    
    public Approvisionnement create(Approvisionnement data){
        return approvisionnementRepository.save(data);
    }
    public Approvisionnement update(Approvisionnement data){
        return approvisionnementRepository.save(data);
    }
    public List<Approvisionnement> findAll(){
        return approvisionnementRepository.findAll();
    }
    public Optional<Approvisionnement> findById(String id){
        return approvisionnementRepository.findById(id);
    }
    public void delete(String id){
        approvisionnementRepository.deleteById(id);
    }
}

