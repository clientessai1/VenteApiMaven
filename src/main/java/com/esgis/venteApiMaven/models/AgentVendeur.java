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

/**
 *
 * @author aristide
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="agentvendeurs")
public class AgentVendeur {
    @Id
    private String id;
    private String nom_agent;
    private String prenom_agent;
}
