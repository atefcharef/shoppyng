package com.shoppyng.panier.controllers;


import com.shoppyng.panier.models.Produit;
import com.shoppyng.panier.services.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Panier conttroller to request panier endPoint : localhost:8080/panier/
 */
@RestController
@RequestMapping("panier")
public class PanierController {

    @Autowired
    private PanierService panierService;

    /**
     * ws add new product to panier
     * @param produit {@Produit}
     */
    @PostMapping(path="/produits", produces = "application/json")
    public void addProduit(@RequestBody Produit produit){

        panierService.addProductToPanier(produit);
    }

    /**
     * ws get list produits in the panier.
     *
     * @return List of {@Produit}
     */
    @GetMapping(path="/list-produits")
    public List<Produit> getProduits() {
        return panierService.listProduit();

    }

    /**
     * delete produit from panier.
     *
     * @param id the produit id
     * @return true when delete success
     */
    @DeleteMapping(path = "/delete-produit/{id}")
    public boolean deleteProduit(@PathVariable Long id){
        return panierService.deleteProductFromPanier(id);
    }

    /**
     * get total price in the panier
     * @return the price of total produits in the panier
     */
    @GetMapping(path = "/total-price")
    public float getTotalPrice() {
        return panierService.totalPrice();
    }


}
