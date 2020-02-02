package com.oguzhanbektas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    @Id
    @SequenceGenerator(name = "seq_person", allocationSize = 1)
    @GeneratedValue(generator = "seq_person")
    private Long id;

    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "surname", length = 25)
    private String surname;

    @OneToMany
    @JoinColumn(name="person_address_id")
    private List<Address> address;
}
