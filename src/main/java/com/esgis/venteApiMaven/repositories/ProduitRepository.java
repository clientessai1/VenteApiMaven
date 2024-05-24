/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.repositories;

import com.esgis.venteApiMaven.models.Boutique;
import com.esgis.venteApiMaven.models.Produit;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author aristide
 */
public interface ProduitRepository  extends MongoRepository<Produit, String>{

}
