/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.repositories;

import com.esgis.venteApiMaven.models.DetailApprovisionnement;
import com.esgis.venteApiMaven.models.DetailVente;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aristide
 */
@Repository
public interface DetailVenteRepository extends MongoRepository<DetailVente, String>{
  
    @Query("{'vente': ?0}")
    List<DetailVente> findAllByVente(ObjectId venteId);    
    
}

