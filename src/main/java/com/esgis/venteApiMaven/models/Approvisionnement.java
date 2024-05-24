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
@Document(collection="approvisionnements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Approvisionnement {
    @Id
    private String id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date_appro;
    @DocumentReference(collection="agentvendeurs")
    private AgentVendeur agent_vendeur;
}
