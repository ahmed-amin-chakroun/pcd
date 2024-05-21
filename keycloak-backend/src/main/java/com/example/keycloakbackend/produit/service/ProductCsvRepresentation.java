package com.example.keycloakbackend.produit.service;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCsvRepresentation {
    @CsvBindByName(column = "category")
    private String category;
    @CsvBindByName(column = "marque")
    private String marque;
    @CsvBindByName(column = "description1")
    private String description1;
    @CsvBindByName(column = "description2")
    private String description2;
    @CsvBindByName(column = "prix")
    private float prix;
    @CsvBindByName(column = "image")
    private String image;
}
