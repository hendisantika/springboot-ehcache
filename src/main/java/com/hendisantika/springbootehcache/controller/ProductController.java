package com.hendisantika.springbootehcache.controller;

import com.hendisantika.springbootehcache.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
