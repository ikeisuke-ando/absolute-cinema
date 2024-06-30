package com.progweb.absolutecinema.config;

import com.progweb.absolutecinema.model.Role;
import com.progweb.absolutecinema.model.User;
import com.progweb.absolutecinema.repositories.RoleRepository;
import com.progweb.absolutecinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());
        var userAdmin = userRepository.findByUsername("admin");
        userAdmin.ifPresentOrElse(
                user -> {
                    System.out.println("admin ja existe");
                },
                () ->{
                    var user = new User();
                    user.setName("Administrador");
                    user.setUsername("admin");
                    user.setPassword(passwordEncoder.encode("123"));
                    user.setRole(Set.of(roleAdmin));
                    userRepository.save(user);
                }

        );
    }
}
