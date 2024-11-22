package com.sid.bloggingapp.Services.Implementation;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sid.bloggingapp.Entities.User;
import com.sid.bloggingapp.Payloads.UserDto;
import com.sid.bloggingapp.Repositiories.UserRepo;
import com.sid.bloggingapp.Services.UserService;
import com.sid.bloggingapp.Utills.UserMapper;
import com.sid.bloggingapp.Exceptions.DuplicateEmailException;
import com.sid.bloggingapp.Exceptions.ResourceNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        try {
            // Convert UserDto to User
            User user = userMapper.dtoToUser(userDto);
            User savedUser = userRepository.save(user);
            // Convert User back to UserDto
            return userMapper.userToDto(savedUser);
        } catch (DataIntegrityViolationException ex) {
            // Handle duplicate email scenario
            if (ex.getCause().getMessage().contains("UKr9kvst217faqa7vgeyy51oos0")) {
                throw new DuplicateEmailException("Email already exists: " + userDto.getEmailId());
            }
            throw ex; // Throw other exceptions as is
        }

    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        // Fetch user by id
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        // Update the user details
        user.setName(userDto.getName());
        user.setEmailId(userDto.getEmailId());
        user.setPassword(userDto.getPassword());

        // Save the updated user
        User updatedUser = userRepository.save(user);
        return userMapper.userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        // Fetch user by id
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return userMapper.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        // Fetch all users
        List<User> users = userRepository.findAll();
        // Convert the list of users to a list of UserDto
        return users.stream()
                .map(userMapper::userToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        // Fetch user by id
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        // Delete the user
        userRepository.delete(user);
    }

}
