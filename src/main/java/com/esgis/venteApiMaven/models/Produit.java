/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.models;

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
@Document(collection="produits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    private String id;
    private String code_produit;
    private String nom_produit;
    @DocumentReference(collection="categories")
    private Categorie categorie;
}
