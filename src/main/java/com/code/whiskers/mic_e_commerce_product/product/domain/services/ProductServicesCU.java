package com.code.whiskers.mic_e_commerce_product.product.domain.services;

import com.code.whiskers.mic_e_commerce_product.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_product.product.domain.entities.Product;
import org.springframework.http.ResponseEntity;

public interface ProductServicesCU {

    public ResponseEntity<ResultResponse<Product>> getProduct(int page, int size, String search, String filter);
    public ResponseEntity<Product> getProduct(Long id);
    public ResponseEntity<Product> postProduct(Product role);
    public ResponseEntity<Product> putProduct(Product role, Long id);
    public ResponseEntity<Product> deleteProduct(Long id);

}
