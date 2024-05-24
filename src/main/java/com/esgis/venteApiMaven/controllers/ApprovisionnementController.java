/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esgis.venteApiMaven.controllers;

import com.esgis.venteApiMaven.models.Approvisionnement;
import com.esgis.venteApiMaven.services.ApprovisionnementService;
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
@RequestMapping("/api/v1/approvisionnements")
public class ApprovisionnementController {
    @Autowired
    private ApprovisionnementService approvisionnementService;
    
    //POST http:localhost:8080/api/approvisionnements/new
    @PostMapping("/new")
    public Approvisionnement createApprovisionnement(@RequestBody Approvisionnement approvisionnement){
        return approvisionnementService.create(approvisionnement);
    }
    
    @GetMapping
    public List<Approvisionnement> findAllApprovisionnement(){
        return approvisionnementService.findAll();
    }
    
    @GetMapping("/{id}")
    public Approvisionnement findOneApprovisionnement(@PathVariable String id){
        Optional<Approvisionnement> approvisionnement = approvisionnementService.findById(id);
        
        if(approvisionnement.isPresent()){
            return approvisionnement.get();
        }
        return null;
    }
    
    @PutMapping("/update/{id}")
    public Approvisionnement updateApprovisionnement(@PathVariable String id, @RequestBody Approvisionnement approvisionnement){
        approvisionnement.setId(id);
        return approvisionnementService.update(approvisionnement);        
    }
    
    //DELETE http:localhost:8080/api/approvisionnements/delete/12
    @DeleteMapping("/delete/{id}")
    public String deleteApprovisionnement(@PathVariable String id){        
        Optional<Approvisionnement> findById = approvisionnementService.findById(id);
        if (findById.isPresent())
        {
            approvisionnementService.delete(id);
            return "Approvisionnement deleted !!!";
        }else
            return "Approvisionnement not found !!!";
        
    }
    
    
}
