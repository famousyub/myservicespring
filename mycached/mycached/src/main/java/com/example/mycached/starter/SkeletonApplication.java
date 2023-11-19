package com.example.mycached.starter;

import com.example.mycached.model.Address;
import com.example.mycached.model.Person;
import com.example.mycached.repository.PeopleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import java.util.Set;

public class SkeletonApplication {
    @Bean
    CommandLineRunner loadTestData(PeopleRepository repo) {
        return args -> {
            repo.deleteAll();

            String thorSays = "The Rabbit Is Correct, And Clearly The Smartest One Among You.";

            // Serendipity, 248 Seven Mile Beach Rd, Broken Head NSW 2481, Australia
            Address thorsAddress = Address.of("248", "Seven Mile Beach Rd", "Broken Head", "NSW", "2481", "Australia");

            Person thor = Person.of("Chris", "Hemsworth", 38, thorSays, new Point(153.616667, -28.716667), thorsAddress, Set.of("hammer", "biceps", "hair", "heart"));

            repo.save(thor);
        };
    }
}
