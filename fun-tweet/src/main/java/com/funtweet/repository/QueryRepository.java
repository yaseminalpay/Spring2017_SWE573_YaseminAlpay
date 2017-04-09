package com.funtweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funtweet.model.Query;

public interface QueryRepository extends JpaRepository<Query, Long> {

}
