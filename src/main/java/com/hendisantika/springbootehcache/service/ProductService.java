package com.hendisantika.springbootehcache.service;

import com.hendisantika.springbootehcache.model.Product;
import com.hendisantika.springbootehcache.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ehcache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-19
 * Time: 05:13
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Cacheable(value = "productsCache")
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    /**
     * Method to fetch product details on the basis of product id.
     *
     * @param productId
     * @return
     */
    // @Cacheable annotation adds the caching behaviour.
    // If multiple requests are received, then the method won't be repeatedly executed, instead, the results are shared from cached storage.
    @Cacheable(value = "productsCache", key = "#p0")
    public Optional<Product> getProductById(int productId) {
        return productRepository.findById(productId);
    }

    /**
     * Method to update product on the basis of product id.
     *
     * @param product
     * @param productName
     * @return
     */
    // @CachePut annotation updates the cached value.
    @CachePut(value = "productsCache")
    public Product updateProductById(Product product, String productName) {
        product.setName(productName);
        productRepository.save(product);

        return product;
    }

    /**
     * Method to delete product on the basis of product id.
     *
     * @param productId
     */
    // @CacheEvict annotation removes one or all entries from cached storage.
    // <code>allEntries=true</code> attribute allows developers to purge all entries from the cache.
    @CacheEvict(value = "productsCache", key = "#p0")
    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }
}