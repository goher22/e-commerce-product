package com.code.whiskers.mic_e_commerce_product.product.application.services;

import com.code.whiskers.mic_e_commerce_product.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_product.product.application.port.in.ProductPortIn;
import com.code.whiskers.mic_e_commerce_product.product.application.port.out.ProductPortOut;
import com.code.whiskers.mic_e_commerce_product.product.domain.entities.Product;

public class ProductServices implements ProductPortIn {

    private final ProductPortOut productPortOut;

    public ProductServices(ProductPortOut productPortOut){
        this.productPortOut = productPortOut;
    }

    @Override
    public ResultResponse<Product> consult(int page, int size, String search, String filter) {
        return this.productPortOut.consult(page, size,search, filter);
    }

    @Override
    public Product show(Long id) {
        return this.productPortOut.show(id);
    }

    @Override
    public Product create(Product product) {
        return this.productPortOut.create(product);
    }

    @Override
    public Product update(Product product, Long id) {
        return this.productPortOut.update(product, id);
    }

    @Override
    public Product delete(Long id) {
        return this.productPortOut.delete(id);
    }
}
