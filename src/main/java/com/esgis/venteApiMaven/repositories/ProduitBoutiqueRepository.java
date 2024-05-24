/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.repositories;

import com.esgis.venteApiMaven.models.Boutique;
import com.esgis.venteApiMaven.models.ProduitBoutique;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aristide
 */
@Repository
public interface ProduitBoutiqueRepository extends MongoRepository<ProduitBoutique, String>{

    /**
     *
     * @param boutiqueId
     * @return
     */
    @Query("{'boutique': ?0}")
    Optional<List<Boutique>> findByBoutique(ObjectId boutiqueId);
    @Query("{'boutique': ?0}")
    List<ProduitBoutique> findAllByBoutique(ObjectId boutiqueId);
        //List<Boutique> findByBoutique(String boutiqueId);    
}

