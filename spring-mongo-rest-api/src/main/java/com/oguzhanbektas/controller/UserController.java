package com.oguzhanbektas.controller;

import com.oguzhanbektas.entity.User;
import com.oguzhanbektas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        User user =new User();
        user.setId("Birinci");
        user.setName("Oğuzhan");
        user.setSurname("BEKTAŞ");
        userRepository.save(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> all() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
