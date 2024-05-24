/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.esgis.venteApiMaven.services;

import com.esgis.venteApiMaven.models.Categorie;
import com.esgis.venteApiMaven.repositories.CategorieRepository;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author aristide
 */

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class CategorieServiceImplTest {
    @Mock
    private CategorieRepository categorieRepository2;
    @InjectMocks
    private CategorieServiceImpl categorieServiceImpl2;

    @BeforeAll
public static void setUp() {
//    MockitoAnnotations.initMocks(this);
    MockitoAnnotations.openMocks(CategorieServiceImplTest.class);
}

@AfterAll
public static void tearDown() {
    //Mockito.reset(categorieRepository2);
}
    
/*    
    public CategorieServiceImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
*/
    /**
     * Test of create method, of class CategorieServiceImpl.
     */
    @Test
    public void testCreate() {
        
      
Categorie cat = new Categorie();
String name = "Test Name";
String id = "012AD";
cat.setId(id);
cat.setNom_categorie(name);
System.out.println("Notre Objet 1 ");
System.out.println(cat);
System.out.println("Notre Objet 2 ");

Mockito.when(this.categorieRepository2.save(Mockito.any(Categorie.class)))
                .thenReturn(cat);
Categorie created = categorieServiceImpl2.create(cat);

System.out.println(created);

        // Verify the result
        
        assertNotNull(created); // Ensure that a Categorie object was created
        System.out.println("TEST not null");
        assertNotNull(created.getId()); // Ensure that the ID is set
        System.out.println("TEST Id not null");
        assertEquals(name, created.getNom_categorie()); // Ensure that the name matches


        System.out.println("Fin du TEST");
    }
    
}
