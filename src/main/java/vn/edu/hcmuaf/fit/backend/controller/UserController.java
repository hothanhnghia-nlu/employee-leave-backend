package vn.edu.hcmuaf.fit.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.backend.model.User;
import vn.edu.hcmuaf.fit.backend.service.UserService;

import java.util.List;

// Url: http://localhost:8081/api/users

@RestController
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new User
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User User) {
        return new ResponseEntity<>(userService.saveUser(User), HttpStatus.CREATED);
    }

    // Get all User
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    // Get User by id
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(userService.getUserByID(id), HttpStatus.OK);
    }

    // Update User by id
    @PutMapping("{id}")
    public ResponseEntity<User> updateUserById(@PathVariable ("id") int id,
                                                   @RequestBody User User) {
        return new ResponseEntity<>(userService.updateUserByID(User, id), HttpStatus.OK);
    }

    // Update User by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable ("id") int id) {
        userService.deleteUserByID(id);
        return new ResponseEntity<>("User " + id + " is deleted successfully!", HttpStatus.OK);
    }

}
