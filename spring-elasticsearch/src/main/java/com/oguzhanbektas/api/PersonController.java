package com.oguzhanbektas.api;


import com.oguzhanbektas.entity.Person;
import com.oguzhanbektas.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    @PostConstruct
    public void init() {
        Person person = new Person();
        person.setId("K0001");
        person.setName("Oguzhan");
        person.setSurname("BEKTAŞ");
        person.setAddress("asdas cad. casad sok. no :2 D:1");
        person.setDateOfBirth(Calendar.getInstance().getTime());
        personRepository.save(person);
    }


    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search) {
        List<Person> persons = personRepository.getByCustomQuery(search);
        return ResponseEntity.ok(persons);
    }
}
