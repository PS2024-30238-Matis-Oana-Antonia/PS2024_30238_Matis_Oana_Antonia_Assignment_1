package com.example.carturestibackend.services;

import com.example.carturestibackend.dtos.ProductDTO;
import com.example.carturestibackend.dtos.builders.ProductBuilder;
import com.example.carturestibackend.entities.Product;
import com.example.carturestibackend.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(ProductBuilder::toProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findProductById(long id_product) {
        Optional<Product> productOptional = productRepository.findById(id_product);
        if (!productOptional.isPresent()) {
            LOGGER.error("Product with id {} was not found in db", id_product);
            throw new ResourceNotFoundException(Product.class.getSimpleName() + " with id: " + id_product);
        }
        return ProductBuilder.toProductDTO(productOptional.get());
    }

    public long insert(ProductDTO productDTO) {
        Product product = ProductBuilder.fromProductDTO(productDTO);
        product = productRepository.save(product);
        LOGGER.debug("Product with id {} was inserted in db", product.getId_product());
        return product.getId_product();
    }

    public void deleteProductById(long id_product) {
        Optional<Product> productOptional = productRepository.findById(id_product);
        if (productOptional.isPresent()) {
            productRepository.delete(productOptional.get());
        } else {
            throw new ResourceNotFoundException(Product.class.getSimpleName() + " with id: " + id_product);
        }
    }

    public ProductDTO updateProduct(long id_product, ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findById(id_product);
        if (!productOptional.isPresent()) {
            LOGGER.error("Product with id {} was not found in db", id_product);
            throw new ResourceNotFoundException(Product.class.getSimpleName() + " with id: " + id_product);
        }

        Product existingProduct = productOptional.get();
        existingProduct.setName(productDTO.getName());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setAuthor(productDTO.getAuthor());
        existingProduct.setStock(productDTO.getStock());

        Product updatedProduct = productRepository.save(existingProduct);
        LOGGER.debug("Product with id {} was updated in db", updatedProduct.getId_product());

        return ProductBuilder.toProductDTO(updatedProduct);
    }
}
