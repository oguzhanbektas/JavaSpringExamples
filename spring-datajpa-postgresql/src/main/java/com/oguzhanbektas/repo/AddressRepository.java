package com.oguzhanbektas.repo;

import com.oguzhanbektas.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
