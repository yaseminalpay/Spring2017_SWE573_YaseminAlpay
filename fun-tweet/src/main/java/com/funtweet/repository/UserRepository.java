package com.funtweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funtweet.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
