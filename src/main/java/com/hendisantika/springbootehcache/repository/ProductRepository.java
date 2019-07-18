package com.hendisantika.springbootehcache.repository;

import com.hendisantika.springbootehcache.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ehcache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-19
 * Time: 05:12
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
