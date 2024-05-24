/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.controllers;

import com.esgis.venteApiMaven.models.DetailVente;
import com.esgis.venteApiMaven.models.Vente;
import com.esgis.venteApiMaven.services.DetailVenteService;
import com.esgis.venteApiMaven.services.VenteService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/api/v1/ventes")
public class VenteController {
       
    @Autowired
    private VenteService venteService;
    
    //POST http:localhost:8080/api/ventes/new
    @PostMapping("/new")
    public Vente createVente(@RequestBody Vente vente){
        return venteService.create(vente);
    }
    
    @GetMapping
    public List<Vente> findAllVente(){
        return venteService.findAll();
    }
    
    @Autowired
    DetailVenteService dtlVenteSvc;
    
    @GetMapping("/withamount")
    public List<?> findAllVenteWithamount(){
        //S'il est vide, le résultat vide est retournée sur le champ.
        if(venteService.findAll().isEmpty())
            return venteService.findAll();
                
        List <Vente> ventes = venteService.findAll();
        ArrayList formattedListVentes = new ArrayList<>();
        
        int[] total = {0};
        ventes.forEach(vente ->{
            
            Map<String, Object> response = new HashMap<>();
            String venteId = vente.getId();
            List<DetailVente> dtlVentes = dtlVenteSvc.findAllByVente(venteId);
       
            JSONObject data1 = new JSONObject();
            int[] montantVente = {0};
            int[] compteur = {0};
            dtlVentes.forEach(dtlVente->{
                compteur[0] ++;
                int montantLigne = dtlVente.getQte_vendue() * dtlVente.getProduit_boutique().getPrix_unit();
                
                Map<String, Object> jsonMap = new LinkedHashMap<>();                
                jsonMap.put("Produit", dtlVente.getProduit_boutique().getProduit().getNom_produit());
                jsonMap.put("Prix unit", dtlVente.getProduit_boutique().getPrix_unit());
                jsonMap.put("Qte vendue", dtlVente.getQte_vendue());
                jsonMap.put("Montant", montantLigne);  
                JSONObject data2 = new JSONObject(jsonMap);
                
                if (compteur[0] == 1){
                    data1.put("Boutique", dtlVente.getProduit_boutique().getBoutique());
                    data1.put("Date vente", vente.getDate_vente());                    
                }

                data1.put("ligne_vente-"+compteur[0], data2);            
                montantVente[0] += montantLigne; 
            });
            
            response.put("Vente", data1.toMap());
            response.put("Total", montantVente[0]);
            
            total[0] += montantVente[0];
            formattedListVentes.add(response);         
        }); 
        
        Map<String, Object> responseTotal = new HashMap<>();
        responseTotal.put("Grand total", total[0]);
        formattedListVentes.add(responseTotal);            
        return formattedListVentes;
    }
    
    
    @GetMapping("/{id}")
    public Vente findOneVente(@PathVariable String id){
        Optional<Vente> vente = venteService.findById(id);
        
        if(vente.isPresent()){
            return vente.get();
        }
        return null;
    }
    
    //DELETE http:localhost:8080/api/ventes/update/12
    @PutMapping("/update/{id}")
    public Vente updateVente(@PathVariable String id, @RequestBody Vente vente){
        vente.setId(id);
        return venteService.update(vente);        
    }
    
    //DELETE http:localhost:8080/api/ventes/delete/12
    @DeleteMapping("/delete/{id}")
    public String deleteVente(@PathVariable String id){
        Optional<Vente> findById = venteService.findById(id);
        if (findById.isPresent())
        {
            venteService.delete(id);
            return "Vente deleted !!!";
            //return true;
        }else
            return "Vente not found !!!";        
            //return false;
                
    }
    
    
}
