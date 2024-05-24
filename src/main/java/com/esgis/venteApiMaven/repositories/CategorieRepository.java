/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.repositories;

import com.esgis.venteApiMaven.models.Categorie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aristide
 */
@Repository
public interface CategorieRepository extends MongoRepository<Categorie, String>{
    
}

