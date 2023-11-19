package com.example.mycached.repository;

import com.example.mycached.model.Person;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

public interface PeopleRepository extends RedisDocumentRepository<Person,String> {
    Iterable<Person> findByAgeBetween(int minAge, int maxAge);
    Iterable<Person> findByFirstNameAndLastName(String firstName, String lastName);

    Iterable<Person> findByHomeLocNear(Point point, Distance distance);

    Iterable<Person> findByAddress_City(String city);

}