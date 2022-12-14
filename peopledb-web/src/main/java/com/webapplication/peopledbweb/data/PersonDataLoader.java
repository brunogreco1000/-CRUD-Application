package com.webapplication.peopledbweb.data;

import com.webapplication.peopledbweb.biz.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class PersonDataLoader implements ApplicationRunner {

    private final PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (personRepository.count() == 0) {
            List<Person> people = List.of(
                 //   new Person(1L,"Paul", "Allen", LocalDate.of(1960,04,07),"paulallen@gmail.com", new BigDecimal("50000")),
                 //   new Person(2L,"Elisabeth", "Shue", LocalDate.of(1970,05,07),"elisabethshue@gmail.com", new BigDecimal("60000")),
                 //   new Person(3L,"Nicolas", "Cage", LocalDate.of(1963,06,07),"nicolascage@gmail.com",new BigDecimal("70000")),
                 //   new Person(4L,"Eric", "Clapton", LocalDate.of(1975,03,07),"ericclapton@gmail.com", new BigDecimal("80000")),
                 //  new Person(5L,"Edward", "Norton", LocalDate.of(1973,02,07),"edwardnorton@gmail.com", new  BigDecimal("90000"))
            );
            personRepository.saveAll(people);
        }
    }
}
