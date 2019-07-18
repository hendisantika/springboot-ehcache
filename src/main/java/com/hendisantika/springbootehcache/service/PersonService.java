package com.hendisantika.springbootehcache.service;

import com.hendisantika.springbootehcache.model.Person;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ehcache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-19
 * Time: 04:39
 */
public interface PersonService {
    List<Person> getAll();
}