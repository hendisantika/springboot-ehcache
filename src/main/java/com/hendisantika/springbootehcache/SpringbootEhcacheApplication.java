package com.hendisantika.springbootehcache;

import com.hendisantika.springbootehcache.model.Person;
import com.hendisantika.springbootehcache.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class SpringbootEhcacheApplication {
    private List<Person> persons = Arrays.asList(
            new Person(1L, "naruto", "uzumaki.naruto@konohagakure.com"),
            new Person(2L, "sasuke", "uchiha.sasuke@konohagakure.com"),
            new Person(3L, "sakura", "sakura.haruno@konohagakure.com"),
            new Person(4L, "kakashi", "hatake.kakashi@konohagakure.com"),
            new Person(5L, "minato", "minato.namikaze@konohagakure.com")
    );

    @Bean
    CommandLineRunner start(PersonRepository personRepository) {
        return args -> {
            personRepository.deleteAll();
            persons.forEach(person -> personRepository.save(person));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEhcacheApplication.class, args);
    }

}
