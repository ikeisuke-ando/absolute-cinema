package com.progweb.absolutecinema.controller;

import com.progweb.absolutecinema.model.User;
import com.progweb.absolutecinema.repositories.LoginRepository;
import com.progweb.absolutecinema.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private UserService userService;
    @GetMapping("/check")
    public String checkLogin(){
        return "login/check";
    }

    @GetMapping("/login")
    public String login() {
        return "login/index";
    }

    @PostMapping("/signIn")
    public String signIn(Model model, User user, String rememberMe) {
        try {
            User usr = this.loginRepository.findUserByLoginPassword(user.getLogin(), user.getPassword());

            if (usr != null) {
                model.addAttribute("login","dummy text");
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