package com.progweb.absolutecinema.controller.api;

import com.progweb.absolutecinema.controller.dto.CreateUserDto;
import com.progweb.absolutecinema.model.User;
import com.progweb.absolutecinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public ResponseEntity<Void> newUser(@RequestBody CreateUserDto dto){
        return this.userService.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = this.userService.findById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/allUsers")
    @PreAuthorize("hasAuthority('SCOPE_admin')")
    public ResponseEntity<List<User>> listAllUsers(){
        List<User> users = this.userService.findAll();
        return ResponseEntity.ok().body(users);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
