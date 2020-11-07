package com.shoppyng.panier.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppyng.panier.controllers.PanierController;
import com.shoppyng.panier.models.Produit;
import com.shoppyng.panier.services.PanierService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@WebMvcTest(PanierController.class)
class PanierServiceImplTest {

    @MockBean
    private PanierService panierService;

    @Autowired
    private MockMvc mockMvc;

    private final AtomicLong counter = new AtomicLong();
    private final List<Produit> produits =
            new ArrayList<Produit>(Arrays.asList(new Produit[]{
                    new Produit(counter.incrementAndGet(), "Produit1", 100),
                    new Produit(counter.incrementAndGet(), "Produit2", 100),
                    new Produit(counter.incrementAndGet(), "Produit3", 100)}));


    @Test
    public void shouldGetListProduitFromPanier() throws Exception {

        Mockito.when(panierService.listProduit()).thenReturn(produits);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/panier/list-produits"))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));
    }


    @Test
    public void shouldAddProduitToPanier() throws Exception {
       Produit produit = new Produit(counter.getAndIncrement(), "mockProduit", 200);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/panier/produits")
        .content(new ObjectMapper().writeValueAsBytes(produit))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
    }

}