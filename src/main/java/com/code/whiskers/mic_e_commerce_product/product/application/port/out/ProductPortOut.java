package com.code.whiskers.mic_e_commerce_product.product.application.port.out;

import com.code.whiskers.mic_e_commerce_product.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_product.product.domain.entities.Product;

public interface ProductPortOut {
    public ResultResponse<Product> consult(int page, int size, String search, String filter);
    public Product show(Long id);
    public Product create(Product product);
    public Product update(Product product, Long id);
    public Product delete(Long id);
}
