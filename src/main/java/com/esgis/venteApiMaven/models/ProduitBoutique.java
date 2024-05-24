/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

/**
 *
 * @author aristide
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="produitboutiques")
public class ProduitBoutique {
    @Id
    private String id;    
    @DocumentReference(collection="produits")
    private Produit produit;
    @DocumentReference(collection="boutiques")
    private Boutique boutique;
    private int qte_prd;
    private int prix_unit;
}
