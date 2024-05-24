/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.models;

import java.util.List;
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
@Document(collection="detailapprovisionnements")
public class DetailApprovisionnement {
    @Id
    private String id;    
    @DocumentReference(collection="produitboutiques")
    private ProduitBoutique produit_boutique;
    @DocumentReference(collection="approvisionnements")
    private Approvisionnement approvisionnement;
    private int qte_appro;
}
