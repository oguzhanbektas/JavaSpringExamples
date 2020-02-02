package com.oguzhanbektas.service.impl;

import com.oguzhanbektas.dto.PersonDto;
import com.oguzhanbektas.entity.Address;
import com.oguzhanbektas.entity.Person;
import com.oguzhanbektas.repo.AddressRepository;
import com.oguzhanbektas.repo.PersonRepository;
import com.oguzhanbektas.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        // Assert.isNull(personDto.getName(), "Name cannot be empty");
//Database Postgres oluştur ve bağlan
//Postman ile istek at
        //http://localhost:8081/person
//        {
//            "name": "Oğuzhan 2",
//                "surname": "BEKTAŞ 2",
//                "address": [
//            "Tet Adress 1 ",
//                    "Tet Adress 1 ",
//                    "Tet Adress 1 "
//    ]
//        }

        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        final Person personDb = personRepository.save(person);
        List<Address> list = new ArrayList<>();
        personDto.getAddress().forEach((item) -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER_ADDRESS);
            address.setActive(true);
            address.setPerson(personDb);
            list.add(address);
        });
        addressRepository.saveAll(list);
        personDto.setId(personDb.getId());
        return personDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        personList.forEach(item -> {
            PersonDto personDto = new PersonDto();
            personDto.setId(item.getId());
            personDto.setName(item.getName());
            personDto.setSurname(item.getSurname());
            personDto.setAddress(item.getAddress().stream().map(Address::getAddress).collect(Collectors.toList()));
            personDtos.add(personDto);
        });
        return personDtos;
    }

    @Override
    public Page<Person> getAll(Pageable pageable) {
        return null;
    }
}
