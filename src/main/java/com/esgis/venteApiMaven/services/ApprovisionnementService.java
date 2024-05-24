/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.Approvisionnement;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author aristide
 */
@Service
public interface ApprovisionnementService {
    
    public Approvisionnement create(Approvisionnement data);
    public Approvisionnement update(Approvisionnement data);
    public List<Approvisionnement> findAll();
    public Optional <Approvisionnement> findById(String id);
    public void delete(String id);
}

