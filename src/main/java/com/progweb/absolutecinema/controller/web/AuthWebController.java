package com.progweb.absolutecinema.controller.web;

import com.progweb.absolutecinema.repositories.LoginRepository;
import com.progweb.absolutecinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthWebController {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {

        if (error != null) {
            model.addAttribute("loginError", "Seu usuário ou senha está inválido.");
        }

        if (logout != null) {
            model.addAttribute("logoutMessage", "Você foi desconectado com sucesso.");
        }

        return "login/login";
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            return ResponseEntity.ok().build();
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválido.");
        }
    }
    @GetMapping("/register")
    public String register(){
        return "register/index";
    }
}