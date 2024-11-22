package com.sid.bloggingapp.Services;

import java.util.List;

import com.sid.bloggingapp.Payloads.UserDto;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);

}
