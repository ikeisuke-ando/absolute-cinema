package com.progweb.absolutecinema.controller;

import com.progweb.absolutecinema.model.User;
import com.progweb.absolutecinema.repositories.LoginRepository;
import com.progweb.absolutecinema.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
public class AuthController {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login/index";
    }

    @PostMapping("/signIn")
    public String signIn(Model model, User user, String rememberMe){

        User usrByEmail = this.loginRepository.findByEmail(user.getEmail(), user.getPassword());
        User usrByUsername = this.loginRepository.findByUsername(user.getLogin(), user.getPassword());

        User usr = usrByEmail != null ? usrByEmail : usrByUsername;

        if (usr != null) {
            return "redirect:/";
        }

        model.addAttribute("loginError", "Usuario ou Senha inválido");

        return "login/index";
    }

    @GetMapping("/register")
    public String register(){
        return "register/index";
    }

    @PostMapping("/signUp")
    @Validated(User.CreateUser.class)
    public ResponseEntity<Void> createUser(@Valid @RequestBody User user){
        this.userService.create(user);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}