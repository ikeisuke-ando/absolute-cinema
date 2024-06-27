package com.progweb.absolutecinema.controller.web;

import com.progweb.absolutecinema.model.User;
import com.progweb.absolutecinema.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = this.userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@Valid @RequestBody User user, @PathVariable Long id){
        user.setId(id);
        user = this.userService.update(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
