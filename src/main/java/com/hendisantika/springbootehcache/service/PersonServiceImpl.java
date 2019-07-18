package com.hendisantika.springbootehcache.service;

import com.hendisantika.springbootehcache.model.Person;
import com.hendisantika.springbootehcache.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Cacheable(value = "personsCache")
    public List<Person> getAll() {
        return personRepository.findAll();
    }

}