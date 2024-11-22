package com.sid.bloggingapp.Utills;

import org.springframework.stereotype.Component;

import com.sid.bloggingapp.Entities.User;
import com.sid.bloggingapp.Payloads.UserDto;

@Component
public class UserMapper {

    // Convert UserDto to User
    public User dtoToUser(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setEmailId(userDto.getEmailId());
        user.setPassword(userDto.getPassword()); // Ensure to hash this password later
        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout()); // Include about field
        return user;
    }

    // Convert User to UserDto
    public UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setEmailId(user.getEmailId());
        userDto.setPassword(user.getPassword()); // Consider omitting this in DTO for security
        userDto.setName(user.getName());
        userDto.setAbout(user.getAbout()); // Include about field
        return userDto;
    }
}
