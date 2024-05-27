package com.code.whiskers.mic_e_commerce_product.product.infrastructure.repositories;

import com.code.whiskers.mic_e_commerce_product.product.infrastructure.models.ProductModelDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryDTO extends JpaRepository<ProductModelDTO, Long> {
}
