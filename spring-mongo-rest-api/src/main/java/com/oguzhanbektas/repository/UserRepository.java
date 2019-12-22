package com.oguzhanbektas.repository;

import com.oguzhanbektas.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<User,String> {
}
