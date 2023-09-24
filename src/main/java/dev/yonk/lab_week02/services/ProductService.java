package dev.yonk.lab_week02.services;

import dev.yonk.lab_week02.enums.ProductStatus;
import dev.yonk.lab_week02.models.Product;
import dev.yonk.lab_week02.repositories.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductService {

    private final ProductRepository productRepository;

    @Inject
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    public Optional<Product> getProductById(long id) {
        return productRepository.getProductById(id);
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public boolean updateProduct(Product product, long id) {
        Optional<Product> productOp = productRepository.getProductById(id);
        if(productOp.isPresent()){
            productRepository.updateProduct(product);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteProduct(long id ) {
        Optional<Product> productOp = productRepository.getProductById(id);
        if(productOp.isPresent()){
            Product product = productOp.get();
            product.setStatus(ProductStatus.TERMINATE);
            productRepository.updateProduct(product);
            return true;
        } else {
            return false;
        }
    }


}
