/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.Vente;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author aristide
 */
@Service
public interface VenteService {
    
    public Vente create(Vente data);
    public Vente update(Vente data);
    public List<Vente> findAll();
    public Optional <Vente> findById(String id);
    public void delete(String id);
}

