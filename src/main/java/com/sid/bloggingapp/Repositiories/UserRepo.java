package com.sid.bloggingapp.Repositiories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.bloggingapp.Entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
