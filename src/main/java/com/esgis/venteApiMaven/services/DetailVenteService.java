/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.DetailVente;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author aristide
 */
@Service
public interface DetailVenteService {
    
    public DetailVente create(DetailVente data);
    public DetailVente update(DetailVente data);
    public List<DetailVente> findAll();
    public Optional <DetailVente> findById(String id);
    public void delete(String id);

    public List<DetailVente> findAllByVente(String venteId);
}

