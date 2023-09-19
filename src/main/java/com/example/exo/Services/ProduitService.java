package com.example.exo.Services;

import com.example.exo.Models.ProduitsDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class ProduitService {

    private final Map<UUID, ProduitsDTO> produits;



    public ProduitService(){
        produits = new HashMap<>();

        ProduitsDTO produitA = ProduitsDTO.builder()
                .id(UUID.randomUUID())
                .label("ordinateur")
                .prix(2555)
                .build();

        ProduitsDTO produitB = ProduitsDTO.builder()
                .id(UUID.randomUUID())
                .label("telephone")
                .prix(520)
                .build();

        ProduitsDTO produitC = ProduitsDTO.builder()
                .id(UUID.randomUUID())
                .label("tablette")
                .prix(742)
                .build();


        produits.put(produitA.getId(),produitA);
        produits.put(produitB.getId(),produitB);
        produits.put(produitC.getId(),produitC);


    }


    public List<ProduitsDTO> getProduits() {
        return produits.values().stream().toList();
    }

    public ProduitsDTO getProduitById(UUID id){
        return produits.values().stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }



}

