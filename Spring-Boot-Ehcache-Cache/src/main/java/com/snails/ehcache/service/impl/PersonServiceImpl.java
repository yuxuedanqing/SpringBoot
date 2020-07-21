package com.snails.ehcache.service.impl;

import com.snails.ehcache.bean.Person;
import com.snails.ehcache.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import java.time.LocalDateTime;
@Service
@CacheDefaults(cacheName = "peopleCache")
public class PersonServiceImpl implements PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

    @CacheResult
    @Override
    public Person getPerson(String name) {
        LOGGER.info("name " + name + " not found in cache. TimeStamp:{}", LocalDateTime.now());
        switch (name){
            case "1234567":
                return new Person(name,"Geoff","Gibson");
            case "98765":
                return new Person(name,"Cory","Beck");
            default:
                return new Person(name,"John","Doe");
        }
    }
}
