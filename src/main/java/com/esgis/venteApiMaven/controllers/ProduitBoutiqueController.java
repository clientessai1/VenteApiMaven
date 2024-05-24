/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.controllers;

import com.esgis.venteApiMaven.models.Boutique;
import com.esgis.venteApiMaven.models.DetailApprovisionnement;
import com.esgis.venteApiMaven.models.ProduitBoutique;
import com.esgis.venteApiMaven.services.BoutiqueService;
import com.esgis.venteApiMaven.services.DetailApprovisionnementService;
import com.esgis.venteApiMaven.services.ProduitBoutiqueService;
//import com.google.gson.Gson;
//import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
//import org.bson.json.JsonObject;
//import org.json.simple.JSONObject;
//import org.json.JSONObject;
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
@RequestMapping("/api/v1/prdbtqs")
public class ProduitBoutiqueController {
    @Autowired
    private ProduitBoutiqueService prdBtqService;
    
    //POST http:localhost:8080/api/boutiques/new
    @PostMapping("/new")
    public ProduitBoutique createPrdBtq(@RequestBody ProduitBoutique produitBoutique){
        return prdBtqService.create(produitBoutique);
    }
    
    @GetMapping
    public List<ProduitBoutique> findAllPrdBtq(){
        return prdBtqService.findAll();
    }

    
    @Autowired
    private BoutiqueService btqSvc;
    @Autowired
    private ProduitBoutiqueService prdBtqSvc;

        
    @Autowired
    DetailApprovisionnementService dtlApproSvc;
        
    public JSONObject stringToJson2(String jsonString) {
        return new JSONObject(jsonString);
    }    
    
    /**
     * Cette méthode affiche les produits d'une boutique dont l'id est fourni via l'endpoint. Avec :
     * - la quantité de chaque produit
     * - le prix unitaire de chaque produit
     * - les informations sur les quantités et dates d'approvisionnement si enregistrées.
    */
    @GetMapping("/{boutiqueId}/produits")
    public List<?>  getProduitsByBoutiqueId(@PathVariable String boutiqueId) {
        
        //S'il est vide, le résultat vide est retournée sur le champ.
        if(prdBtqService.findAllByBoutique(boutiqueId).isEmpty())
        return prdBtqService.findAllByBoutique(boutiqueId);
        
        List <ProduitBoutique> prdBtqs = prdBtqService.findAllByBoutique(boutiqueId);
        ArrayList formattedListPrdBtqs = new ArrayList<>();
        
        int[] compteur = {0};//Voici le genre de compteur à utiliser dans une fonction lambda en java.
        prdBtqs.forEach(prdBtq ->{
            
            Map<String, Object> response = new HashMap<>();
            String prdbtqId = prdBtq.getId();
            List<DetailApprovisionnement> dtlAppros = dtlApproSvc.findAllByProduitBoutiqueId(prdbtqId);
       
            JSONObject dataInfoAppro = new JSONObject();
             
            dtlAppros.forEach(dtlAppro->{
                Date dateAppro  = dtlAppro.getApprovisionnement().getDate_appro();
                        
                dataInfoAppro.put("qte_appro", dtlAppro.getQte_appro());
                dataInfoAppro.put("date_appro", dateAppro);
            });

            response.put("produit_boutique_id", prdBtq.getId());
            response.put("produit", prdBtq.getProduit());
            response.put("prix_unit", prdBtq.getPrix_unit());
            response.put("qte_prd", prdBtq.getQte_prd());
            response.put("info_appro", dataInfoAppro.toMap());
        
            if (compteur[0] == 0)
            {
                Map<String, Object> responseBtq = new HashMap<>();   
                responseBtq.put("boutique ",prdBtq.getBoutique());   
                formattedListPrdBtqs.add(responseBtq);
            }
                
            formattedListPrdBtqs.add(response);
            compteur[0]++;
        });
        return formattedListPrdBtqs;        
    }

    /**
     * Cette méthode affiche la liste des produits dans les boutiques avec les détails sur :
     * - la quantité du produit
     * - le prix unitaire du produit
     * - les informations sur les quantités et dates d'approvisionnement si enregistrées.
    */
    @GetMapping("/stockdetail")
    public List<?>  getProduitBoutiqueDetailStock() {
        
        //S'il est vide, le résultat vide est retournée sur le champ.
        if(prdBtqService.findAll().isEmpty())
            return prdBtqService.findAll();
        
        List <ProduitBoutique> prdBtqs = prdBtqService.findAll();
        ArrayList formattedListPrdBtqs = new ArrayList<>();
        
        prdBtqs.forEach(prdBtq ->{
            
            Map<String, Object> response = new HashMap<>();
            String prdbtqId = prdBtq.getId();
            List<DetailApprovisionnement> dtlAppros = dtlApproSvc.findAllByProduitBoutiqueId(prdbtqId);
       
            JSONObject dataInfoAppro = new JSONObject();
             
            dtlAppros.forEach(dtlAppro->{
                Date dateAppro  = dtlAppro.getApprovisionnement().getDate_appro();
                        
                dataInfoAppro.put("qte_appro", dtlAppro.getQte_appro());
                dataInfoAppro.put("date_appro", dateAppro);
            });
            
            response.put("info_appro", dataInfoAppro.toMap());
            response.put("produit_boutique", prdBtq);
                        
            formattedListPrdBtqs.add(response);         
        });
        return formattedListPrdBtqs;
    }
    
    @GetMapping("/{id}")
    public ProduitBoutique findOnePrdBtq(@PathVariable String id){
        Optional<ProduitBoutique> prdBtq = prdBtqService.findById(id);
        
        if(prdBtq.isPresent()){
            return prdBtq.get();
        }
        return null;
    }
    
    @PutMapping("/update/{id}")
    public ProduitBoutique updatePrdBtq(@PathVariable String id, @RequestBody ProduitBoutique prdBtq){
        prdBtq.setId(id);
        return prdBtqService.update(prdBtq);        
    }
    
    //DELETE http:localhost:8080/api/boutiques/delete/12
    @DeleteMapping("/delete/{id}")
    public String deletePrdBtq(@PathVariable String id){

        Optional<ProduitBoutique> findById = prdBtqService.findById(id);
        if (findById.isPresent())
        {
            prdBtqService.delete(id);
            return "ProduitBoutique deleted !!!";
            //return true;
        }else
            return "ProduitBoutique not found !!!";        
            //return false;        
    }
       
}
