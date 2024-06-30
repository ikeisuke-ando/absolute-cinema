//package com.progweb.absolutecinema.controller.web;
//
//import com.progweb.absolutecinema.model.User;
//import com.progweb.absolutecinema.services.AdminService;
//import com.progweb.absolutecinema.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/admin")
//@Validated
//public class AdminWebController {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private AdminService adminService;
//
//    @GetMapping("/admin")
//    public String admin(Model model,User user) {
//        try{
//            if (adminService.isAdmin(user)){
//                return "admin/index";
//            }
//            throw new Exception("Você não tem permissão para acessar aqui");
//        }catch (Exception e) {
//            model.addAttribute("adminError", e.getMessage());
//            return "register/index";
//        }
//    }
//}
