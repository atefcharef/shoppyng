package com.shoppyng.panier.models;

import java.util.List;

public class Panier {

    private List<Produit> produits;

    /**
     * get list produit {@Produit}
     * @return list {@Produit}
     */
    public List<Produit> getProduits() {
        return produits;
    }

    /**
     * set list produits {@Produit}
     * @param produits {@Produit}
     */
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }


}
