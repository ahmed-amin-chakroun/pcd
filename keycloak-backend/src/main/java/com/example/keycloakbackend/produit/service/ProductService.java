package com.example.keycloakbackend.produit.service;

import com.example.keycloakbackend.produit.model.Product;
import com.example.keycloakbackend.produit.repository.ProductRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public Product postProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Integer uploadProducts(MultipartFile file) throws IOException {
        Set<Product> products = parseCsv(file);
        productRepository.saveAll(products);
        return products.size();
    }
    private Set<Product> parseCsv(MultipartFile file) throws IOException {
        try(Reader reader = new BufferedReader(new FileReader("product.csv"))) {
            HeaderColumnNameMappingStrategy<ProductCsvRepresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(ProductCsvRepresentation.class);
            CsvToBean<ProductCsvRepresentation> csvToBean =
                    new CsvToBeanBuilder<ProductCsvRepresentation>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();
            return csvToBean.parse()
                    .stream()
                    .map(csvLine -> Product.builder()
                            .category(csvLine.getCategory())
                            .marque(csvLine.getMarque())
                            .description1(csvLine.getDescription1())
                            .description2(csvLine.getDescription2())
                            .prix(csvLine.getPrix())
                            .image(csvLine.getImage())
                            .build()
                    )
                    .collect(Collectors.toSet());
        }
    }
}
