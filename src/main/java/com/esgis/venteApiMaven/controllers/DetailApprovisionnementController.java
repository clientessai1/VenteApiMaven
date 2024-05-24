/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.controllers;

import com.esgis.venteApiMaven.models.DetailApprovisionnement;
import com.esgis.venteApiMaven.models.ProduitBoutique;
import com.esgis.venteApiMaven.repositories.ProduitBoutiqueRepository;
import com.esgis.venteApiMaven.repositories.ProduitRepository;
import com.esgis.venteApiMaven.services.DetailApprovisionnementService;
import com.esgis.venteApiMaven.services.ProduitBoutiqueService;
import com.esgis.venteApiMaven.services.ProduitBoutiqueServiceImpl;
import com.esgis.venteApiMaven.services.ProduitServiceImpl;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/v1/dtlappros")
public class DetailApprovisionnementController {
    
    @Autowired
    private DetailApprovisionnementService detailApproService;

    @Autowired
    ProduitBoutiqueService prbSvc ;
    
    @PostMapping("/new")
    public DetailApprovisionnement create(@RequestBody DetailApprovisionnement detailAppro) {
        int reqQteAppro = detailAppro.getQte_appro();
        String reqPrdBtqId = detailAppro.getProduit_boutique().getId();
        ProduitBoutique prdBtq;
        
        /*Si un produitBoutique existe dans la bdd avec reqPrdBtqId alors nous augmentons 
        la quantité initiale avec la quantité approvisionnée*/
        if (prbSvc.findById(reqPrdBtqId).isPresent())
        {            
            prdBtq = prbSvc.findById(reqPrdBtqId).get();
            int qteTotal = prdBtq.getQte_prd() + reqQteAppro;
            prdBtq.setQte_prd(qteTotal);
            prbSvc.update(prdBtq);
        }
        //Création de detail approvisionnement dans la base et son renvoie à l'utilisateur.
        return detailApproService.create(detailAppro);
        
    }

    @GetMapping
    public List<DetailApprovisionnement> findAllDetailApprovisionnements() {
        return detailApproService.findAll();
    }

    @GetMapping("/{id}")
    public DetailApprovisionnement findOneDetailApprovisionnements(@PathVariable String id) {
        Optional<DetailApprovisionnement> produit = detailApproService.findById(id);
        if (produit.isPresent()) {
            return produit.get();
        }
        return null;
    }

    //DELETE http:localhost:8080/api/dtlappros/update/12
    @PutMapping("/update/{id}")
    public DetailApprovisionnement updateDetailApprovisionnement(@PathVariable String id, @RequestBody DetailApprovisionnement produit) {
        produit.setId(id);
        return detailApproService.update(produit);
    }

    //DELETE http:localhost:8080/api/dtlappros/delete/12
    @DeleteMapping("/delete/{id}")
    public String deleteDetailApprovisionnement(@PathVariable String id) {
        Optional<DetailApprovisionnement> findById = detailApproService.findById(id);
        if (findById.isPresent())
        {
            detailApproService.delete(id);
            return "DetailApprovisionnement deleted !!!";
        }else
            return "DetailApprovisionnement not found !!!";
    }


}
