package com.example.exo.Controller;


import com.example.exo.Models.ProduitsDTO;
import com.example.exo.Services.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
@RequestMapping("/base")
public class ControllerProduit {

    private final ProduitService produitService;

    public ControllerProduit(ProduitService produitService) {
        this.produitService = produitService;
    }


    @GetMapping("/produit/listing")
    public String listProduits(Model model) {
        model.addAttribute("produits", produitService.getProduits());
        return "produit/ListProduits";
    }


    @GetMapping("/produit/{id}")
    public String produitDetails(@PathVariable("id") UUID id, Model model) {

        ProduitsDTO produit = produitService.getProduitById(id);
        model.addAttribute("produit", produit);

        return "produit/produit";
    }

}


