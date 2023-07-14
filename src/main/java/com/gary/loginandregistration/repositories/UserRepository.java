package com.gary.loginandregistration.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gary.loginandregistration.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    // create findByEmail
	Optional<User> findByEmail(String email);
}