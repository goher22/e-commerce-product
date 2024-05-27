package com.code.whiskers.mic_e_commerce_product.product.infrastructure.controller;

import com.code.whiskers.mic_e_commerce_product.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_product.product.application.port.in.ProductPortIn;
import com.code.whiskers.mic_e_commerce_product.product.application.services.ProductServices;
import com.code.whiskers.mic_e_commerce_product.product.domain.entities.Product;
import com.code.whiskers.mic_e_commerce_product.product.domain.services.ProductServicesCU;
import com.code.whiskers.mic_e_commerce_product.product.infrastructure.service.ProductMysqlAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController implements ProductServicesCU {

    private final ProductPortIn productPortIn;

    public ProductController(ProductMysqlAdapter productMysqlAdapter) {
        this.productPortIn = new ProductServices(productMysqlAdapter);
    }

    @Override
    @GetMapping
    public ResponseEntity<ResultResponse<Product>> getProduct(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String filter) {

        ResultResponse<Product> products = this.productPortIn.consult(page,size,search,filter);

        return ResponseEntity.ok(products);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product  product = productPortIn.show(id);
        if(product != null){
            return ResponseEntity.ok(product);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<Product> postProduct(@RequestBody Product product) {
        try{
            Product createProduct = productPortIn.create(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Product> putProduct(@RequestBody Product product, @PathVariable Long id) {
        Product updateProduct = productPortIn.update(product, id);
        if(updateProduct != null) {
            return ResponseEntity.ok(updateProduct);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Product deleteProduct = productPortIn.delete(id);
        if(deleteProduct != null){
            return ResponseEntity.ok(deleteProduct);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
