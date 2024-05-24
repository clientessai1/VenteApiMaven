/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.DetailApprovisionnement;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author aristide
 */
@Service
public interface DetailApprovisionnementService {
    
    public DetailApprovisionnement create(DetailApprovisionnement data);
    public DetailApprovisionnement update(DetailApprovisionnement data);
    public List<DetailApprovisionnement> findAll();
    public Optional <DetailApprovisionnement> findById(String id);
    public void delete(String id);

    public List<DetailApprovisionnement> findAllByProduitBoutiqueId(String prdbtqId);
}

