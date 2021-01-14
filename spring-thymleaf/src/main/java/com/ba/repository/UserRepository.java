package com.ba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ba.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
