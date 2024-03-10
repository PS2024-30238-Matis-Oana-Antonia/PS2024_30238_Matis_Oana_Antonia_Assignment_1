package com.example.carturestibackend.controllers;

import com.example.carturestibackend.services.ProductService;
import com.example.carturestibackend.dtos.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<ProductDTO> dtos = productService.findProducts();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertProduct(@Valid @RequestBody ProductDTO productDTO) {
        long productID = productService.insert(productDTO);
        return new ResponseEntity<>(productID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id_product}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id_product") long productID) {
        ProductDTO dto = productService.findProductById(productID);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id_product}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id_product") long productID) {
        productService.deleteProductById(productID);
        return new ResponseEntity<>("Product with ID " + productID + " deleted successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/{id_product}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id_product") long productID, @Valid @RequestBody ProductDTO productDTO) {
        ProductDTO updatedProduct = productService.updateProduct(productID, productDTO);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
}
