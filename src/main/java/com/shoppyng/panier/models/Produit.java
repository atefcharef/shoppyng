package com.shoppyng.panier.models;

public class Produit {

    private Long idProduit;
    private String nameProduit;
    private float price;

    /**
     * constructor for produit
     * @param idProduit the id produit
     * @param nameProduit the name produit
     * @param price the produit price
     */
    public Produit(Long idProduit, String nameProduit, float price) {
        this.idProduit = idProduit;
        this.nameProduit = nameProduit;
        this.price = price;
    }

    /**
     *
     * @return
     */
    public Long getIdProduit() {
        return idProduit;
    }

    /**
     *
     * @param idProduit
     */
    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    /**
     *
     * @return
     */
    public String getNameProduit() {
        return nameProduit;
    }

    /**
     *
     * @param nameProduit
     */
    public void setNameProduit(String nameProduit) {
        this.nameProduit = nameProduit;
    }

    /**
     *
     * @return
     */
    public float getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }
}
