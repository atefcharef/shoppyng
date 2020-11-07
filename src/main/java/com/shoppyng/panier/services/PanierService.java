package com.shoppyng.panier.services;

import com.shoppyng.panier.models.Produit;

import java.util.List;

public interface PanierService {

    /**
     * add produit to panier
     *
     * @param produit {@Produit}
     */
     void addProductToPanier(Produit produit);


    /**
     * delete produit from panier.
     *
     * @param idProduit the produit id
     *
     * @return true when produit deleted false otherwise
     */
    boolean deleteProductFromPanier(Long idProduit);

    /**
     * get list of product in Panier.
     *
     * @return the list produits List<{@Produit}>
     */
    List<Produit> listProduit();

    /**
     * get total price of panier
     * @return the price of total price {@float}
     */
    float totalPrice();

}
