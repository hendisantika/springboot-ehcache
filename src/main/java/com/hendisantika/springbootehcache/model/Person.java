package com.hendisantika.springbootehcache.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ehcache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-19
 * Time: 04:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    private Long id;
    private String nickname;
    private String email;

}