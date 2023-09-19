package com.example.exo.Controller;
import com.example.exo.Models.ProduitsDTO;
import com.example.exo.Services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/produits")
public class ContollerRestProduit {

    private final ProduitService produitService;



        @GetMapping("listing")
        public List<ProduitsDTO> list() {
            return produitService.getProduits();
        }

        @GetMapping("details/{produitId}")
        public ResponseEntity<ProduitsDTO> getProduitById(@PathVariable("produitId") UUID id) {
            ProduitsDTO found = produitService.getProduitById(id);

            if (found != null) {
                return ResponseEntity.ok(found);
            } else {
                return new ResponseEntity<ProduitsDTO>(HttpStatus.NOT_FOUND);
            }
        }
    }

