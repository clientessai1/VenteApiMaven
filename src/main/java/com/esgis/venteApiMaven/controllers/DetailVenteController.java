/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.controllers;

import com.esgis.venteApiMaven.models.Boutique;
import com.esgis.venteApiMaven.models.DetailApprovisionnement;
import com.esgis.venteApiMaven.models.DetailVente;
import com.esgis.venteApiMaven.models.ProduitBoutique;
import com.esgis.venteApiMaven.services.BoutiqueService;
import com.esgis.venteApiMaven.services.DetailVenteService;
import com.esgis.venteApiMaven.services.ProduitBoutiqueService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aristide
 */
@RestController
@RequestMapping("/api/v1/dtlventes")
public class DetailVenteController {
    @Autowired
    private DetailVenteService detailVenteService;

    @Autowired
    ProduitBoutiqueService prbSvc ;
    
    //POST http:localhost:8080/api/boutiques/new
    @PostMapping("/new")
    public DetailVente createDetailVente(@RequestBody DetailVente detailVente){
        //Récupération des paramètres clés de la requête
        int reqQteVendue = detailVente.getQte_vendue();
        String reqPrdBtqId = detailVente.getProduit_boutique().getId();
        ProduitBoutique prdBtq;        

        /*Si un produitBoutique existe dans la bdd avec reqPrdBtqId alors nous diminuons 
        la quantité initiale avec la quantité vendue*/
        if (prbSvc.findById(reqPrdBtqId).isPresent())
        {            
            prdBtq = prbSvc.findById(reqPrdBtqId).get();
            int qteStock = prdBtq.getQte_prd();
            int qteRestant = qteStock - reqQteVendue;
            if ( qteStock > 0 && qteRestant > 0)
            {
                prdBtq.setQte_prd(qteRestant);
                prbSvc.update(prdBtq);                
            }

        }
        //Création de detail approvisionnement dans la base et son renvoie à l'utilisateur.                
        return detailVenteService.create(detailVente);
    }
    
    @GetMapping
    public List<DetailVente> findAllDetailVente(){
        return detailVenteService.findAll();
    }

    
    @GetMapping("/{id}")
    public DetailVente findOneDetailVente(@PathVariable String id){
        Optional<DetailVente> detailVente = detailVenteService.findById(id);
        
        if(detailVente.isPresent()){
            return detailVente.get();
        }
        return null;
    }
    
    @GetMapping("/2/{id}")
    public Map <String, Object> findOneDetailVente2(@PathVariable String id){
        Optional<DetailVente> detailVente = detailVenteService.findById(id);
        
        if(detailVente.isPresent()){
            Map <String, Object> response = new HashMap<>();
            response.put("detailVente", detailVente.get());
            response.put("responsable", "respo");
            return response;
            //return detailVente.get();            
        }
        return null;
    }
    
    @PutMapping("/update/{id}")
    public DetailVente updateDetailVente(@PathVariable String id, @RequestBody DetailVente detailVente){
        detailVente.setId(id);
        return detailVenteService.update(detailVente);        
    }
    
    //DELETE http:localhost:8080/api/dtlventes/delete/12
    @DeleteMapping("/delete/{id}")
    public String deleteDetailVente(@PathVariable String id){

        Optional<DetailVente> findById = detailVenteService.findById(id);
        if (findById.isPresent())
        {
            detailVenteService.delete(id);
            return "DetailVente deleted !!!";
            //return true;
        }else
            return "DetailVente not found !!!";        
            //return false;
        
    }
    
    
}
