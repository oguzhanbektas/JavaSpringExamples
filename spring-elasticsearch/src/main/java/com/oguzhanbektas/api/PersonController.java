package com.oguzhanbektas.api;


import com.oguzhanbektas.entity.Person;
import com.oguzhanbektas.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    public void init() {
        Person person = new Person();
        person.setId("K0001");
        person.setName("Oguzhan");
        person.setSurname("BEKTAŞ");
        person.setAddress("asdas cad. casad sok. no :2 D:1");
        person.setDateOfBirth(Calendar.getInstance().getTime());
        System.out.println(person);
        personRepository.save(person);
    }

    @RequestMapping(value = "/{search}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search) {
        List<Person> persons = personRepository.getByCustomQuery(search);
        //List<Person> persons = personRepository.findByNameLikeOrSurnameLike(search, search);
        System.out.println("-------------------------------------------------------------");
        System.out.println(search);
        System.out.println(persons);
        return ResponseEntity.ok(persons);
    }
}
