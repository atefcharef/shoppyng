package com.shoppyng.panier.services.impl;

import com.shoppyng.panier.models.Produit;
import com.shoppyng.panier.services.PanierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class PanierServiceImpl implements PanierService {

    private final AtomicLong counter = new AtomicLong();

    private final List<Produit> produits =
            new ArrayList<Produit>(Arrays.asList(new Produit[]{
                    new Produit(counter.incrementAndGet(), "Produit1", 100),
                    new Produit(counter.incrementAndGet(), "Produit2", 100),
                    new Produit(counter.incrementAndGet(), "Produit3", 100)}));

    @Override
    public void addProductToPanier(Produit produit) {
         produits.add(new Produit(counter.incrementAndGet(),
                produit.getNameProduit(),
                produit.getPrice()));
    }

    @Override
    public boolean deleteProductFromPanier(Long idProduit) {
        return this.produits.removeIf(produit -> produit.getIdProduit() == idProduit);
    }

    @Override
    public List<Produit> listProduit() {
        return this.produits;
    }

    @Override
    public float totalPrice() {
        return (float) this.produits.stream().mapToDouble(Produit::getPrice).sum();
    }
}
