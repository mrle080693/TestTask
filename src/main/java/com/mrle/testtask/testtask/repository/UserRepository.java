package com.mrle.testtask.testtask.repository;

import com.mrle.testtask.testtask.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {}
