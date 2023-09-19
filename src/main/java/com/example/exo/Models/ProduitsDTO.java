package com.example.exo.Models;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProduitsDTO {

    private UUID id;
    private String label;
    private long prix;
}

