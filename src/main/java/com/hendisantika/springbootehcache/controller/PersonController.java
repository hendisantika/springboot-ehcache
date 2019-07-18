package com.hendisantika.springbootehcache.controller;

import com.hendisantika.springbootehcache.model.Person;
import com.hendisantika.springbootehcache.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Cacheable;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ehcache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-19
 * Time: 04:40
 */
@RestController
public class PersonController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    @Cacheable("persons")
    public List<Person> index() {
        log.info("Getting all persons");
        long start = new Date().getTime();
        List<Person> persons = personService.getAll();
        log.info("Finishing getting all persons at: " + (new Date().getTime() - start) + " milliseconds");
        return persons;
    }

}