package com.hendisantika.springbootehcache.controller;

import com.hendisantika.springbootehcache.model.Product;
import com.hendisantika.springbootehcache.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ehcache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-19
 * Time: 05:16
 */
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
    @Autowired
    private ProductService pserv;

    /**
     * Method to fetch product details on the basis of product id.
     */
    @GetMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        List<Product> product = (List<Product>) pserv.getAllProducts();
        if (product.isEmpty()) {
            return new ResponseEntity<Iterable<Product>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Iterable<Product>>(product, HttpStatus.OK);
    }


    /**
     * Method to fetch product details on the basis of product id.
     *
     * @param productId
     * @return
     */
    @GetMapping(value = "/{product-id}")
    @ResponseBody
    public ResponseEntity<Product> getProductById(@PathVariable("product-id") int productId) {
        Optional<Product> product = pserv.getProductById(productId);
        if (!product.isPresent())
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
    }

    /**
     * Method to update product on the basis of product id.
     *
     * @param productId
     * @param productName
     * @return
     */
    @PutMapping(value = "/{product-id}/{product-name}")
    public ResponseEntity<Product> updateTicketById(@PathVariable("product-id") int productId, @PathVariable("product-name") String productName) {
        Optional<Product> product = pserv.getProductById(productId);
        if (!product.isPresent())
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Product>(pserv.updateProductById(product.get(), productName), HttpStatus.OK);
    }

    /**
     * Method to delete product on the basis of product id.
     *
     * @param productId
     */
    @DeleteMapping(value = "/{product-id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable("product-id") int productId) {
        Optional<Product> product = pserv.getProductById(productId);
        if (!product.isPresent())
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

        pserv.deleteProductById(productId);
        return new ResponseEntity<Product>(HttpStatus.ACCEPTED);
    }

}
