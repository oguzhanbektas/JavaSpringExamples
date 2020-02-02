package com.oguzhanbektas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "person_address")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_person_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address")
    private Long id;

    @Column(name = "address", length = 500, unique = false, nullable = true)
    private String address;

    @Enumerated
    private AddressType addressType;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="person_address_id")
    private Person person;

    public enum AddressType {
        HOME_ADDRESS,
        BUSINESS_ADDRESS,
        OTHER_ADDRESS
    }
}
