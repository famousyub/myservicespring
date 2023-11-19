package com.example.mycached.service;


import java.util.stream.Collectors;

import com.example.mycached.model.Person;
import io.redisearch.aggregation.SortedField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.om.spring.search.stream.EntityStream;

@Service
public class PeopleService {
    @Autowired
    EntityStream entityStream;

    // Find all people
    public Iterable<Person> findAllPeople(int minAge, int maxAge) {
        return entityStream //
                .of(Person.class) //
                .collect(Collectors.toList());
    }

    public Iterable<Person> findByAgeBetween(int minAge, int maxAge) {
        return entityStream //
                .of(Person.class) //
               // .filter(new  Person().getAge().between(minAge, maxAge)) //
                //.sorted(new Person().getAge(), SortedField.SortOrder.ASC) //
                .collect(Collectors.toList());
    }

    public Iterable<Person> findByFirstNameAndLastName(String firstName, String lastName) {
        return entityStream //
                .of(Person.class) //
               // .filter(new Person().getFirstName().equals(firstName)) //
                //.filter(Person.LAST_NAME.eq(lastName)) //
                .collect(Collectors.toList());
    }

}
