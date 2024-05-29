package com.code.whiskers.mic_e_commerce_product.product.infrastructure.service;

import com.code.whiskers.mic_e_commerce_product.common.domain.PageDomain;
import com.code.whiskers.mic_e_commerce_product.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_product.product.application.port.out.ProductPortOut;
import com.code.whiskers.mic_e_commerce_product.product.domain.entities.Product;
import com.code.whiskers.mic_e_commerce_product.product.infrastructure.models.ProductModelDTO;
import com.code.whiskers.mic_e_commerce_product.product.infrastructure.repositories.ProductRepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductMysqlAdapter implements ProductPortOut {

    @Autowired
    private ProductRepositoryDTO productRepositoryDTO;

    @Override
    public ResultResponse<Product> consult(int page, int size, String search, String filter) {
        try{
            Page<ProductModelDTO> productPage = productRepositoryDTO.findAll(PageRequest.of(page, size));
            List<ProductModelDTO> products = productPage.getContent();

            List<Product> productList = products.stream()
                    .map(productModelDTO -> new Product(
                                    productModelDTO.getId(),
                                    productModelDTO.getName(),
                                    productModelDTO.getDescription(),
                                    productModelDTO.getPrice(),
                                    productModelDTO.getStock()
                            )
                    ).toList();
            PageDomain pageDomain = new PageDomain(
                    productPage.getTotalPages(),
                    size,
                    page,
                    "/api/product"
            );
            return new ResultResponse<>(pageDomain, productList);
        }catch (Exception e){
            throw  e;
        }

    }

    @Override
    public Product show(Long id) {
        Optional<ProductModelDTO> optionalProduct = productRepositoryDTO.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Product create(Product product) {
        return productRepositoryDTO.save(new ProductModelDTO(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock()
            )
        );
    }

    @Override
    public Product update(Product product, Long id) {
        Optional<ProductModelDTO> optionalProduct = productRepositoryDTO.findById(id);
        if(optionalProduct.isPresent()){
            ProductModelDTO editProduct = optionalProduct.get();
            editProduct.setName(product.getName());
            editProduct.setDescription(product.getDescription());
            editProduct.setPrice(product.getPrice());
            editProduct.setStock(product.getStock());

            return productRepositoryDTO.save(editProduct);
        }
        return null;
    }

    @Override
    public Product delete(Long id) {
        Optional<ProductModelDTO> optionalProduct = productRepositoryDTO.findById(id);
        if(optionalProduct.isPresent()){
            productRepositoryDTO.deleteById(id);
            return optionalProduct.get();
        }
        return null;
    }
}
