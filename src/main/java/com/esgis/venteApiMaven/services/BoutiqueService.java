/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.Boutique;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author aristide
 */
@Service
public interface BoutiqueService {
    
    public Boutique create(Boutique data);
    public Boutique update(Boutique data);
    public List<Boutique> findAll();
    public Optional <Boutique> findById(String id);
    public void delete(String id);
}

