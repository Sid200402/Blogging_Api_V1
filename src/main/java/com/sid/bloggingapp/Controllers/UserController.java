package com.sid.bloggingapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sid.bloggingapp.Payloads.UserDto;
import com.sid.bloggingapp.Payloads.ApiResponse;
import com.sid.bloggingapp.Services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping("/")
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(
                new ApiResponse("User created successfully with ID: " + createdUser.getUserId(), true),
                HttpStatus.CREATED);
    }

    // Update an existing user
    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId) {
        userService.updateUser(userDto, userId); // Perform the update operation without assigning it to a local
                                                 // variable
        return ResponseEntity.ok(new ApiResponse("User with ID: " + userId + " updated successfully.", true));
    }

    // Get user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    // Get all users
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Delete a user by ID
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User with ID: " + userId + " deleted successfully.", true),
                HttpStatus.OK);
    }
}
