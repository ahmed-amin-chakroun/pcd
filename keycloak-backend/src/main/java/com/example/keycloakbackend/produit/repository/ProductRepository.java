package com.example.keycloakbackend.produit.repository;

import com.example.keycloakbackend.produit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}