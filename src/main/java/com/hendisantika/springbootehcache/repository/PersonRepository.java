package com.hendisantika.springbootehcache.repository;

import com.hendisantika.springbootehcache.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ehcache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-19
 * Time: 04:38
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person save(Person person);

    List<Person> findAll();

    void deleteAll();

}