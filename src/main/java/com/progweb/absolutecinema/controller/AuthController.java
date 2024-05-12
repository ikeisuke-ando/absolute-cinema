package com.progweb.absolutecinema.controller;

import com.progweb.absolutecinema.model.User;
import com.progweb.absolutecinema.repositories.LoginRepository;
import com.progweb.absolutecinema.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.StyleSheet;
import java.io.IOException;

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
    public String signIn(Model model, User user, String rememberMe) {
        try {
            User usrByEmail = this.loginRepository.findByEmail(user.getEmail(), user.getPassword());
            User usrByUsername = this.loginRepository.findByUsername(user.getLogin(), user.getPassword());

            User usr = usrByEmail != null ? usrByEmail : usrByUsername;

            if (usr != null) {
                Model usModel;
                boolean loggedIn = true;
                model.addAttribute("loggedIn", loggedIn);
                return "redirect:/";
            }
            throw new Exception("Usuário ou senha inválido.");

        } catch (Exception e) {
            model.addAttribute("loginError", e.getMessage());
            return "login/index";
        }
    }


    @GetMapping("/register")
    public String register(){
        return "register/index";
    }

    @PostMapping("/signUp")
    public String signUp(Model model, @Valid User user){
        try{

            if (user.getId() != null) {
                if(user.getId() != null && user.getEmail() != null){
                    this.userService.create(user);
                    return "redirect:/";
                }
            }
            throw new Exception("Campos obrigatórios não preenchidos!!!");
        }
        catch (Exception e) {
            model.addAttribute("registerError", e.getMessage());
            return "register/index";
        }
    }
}