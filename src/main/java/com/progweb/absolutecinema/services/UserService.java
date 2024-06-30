package com.progweb.absolutecinema.services;

import com.progweb.absolutecinema.controller.dto.CreateUserDto;
import com.progweb.absolutecinema.model.Role;
import com.progweb.absolutecinema.model.User;
import com.progweb.absolutecinema.repositories.RoleRepository;
import com.progweb.absolutecinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("Usuário " + id + " não encontrado"));
    }

    public List<User> findAll() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new RuntimeException("Nenhum usuário encontrado");
        }

        return users;
    }

    @Transactional
    public ResponseEntity<Void> create(@RequestBody CreateUserDto dto){

        var basicRole = roleRepository.findByName(Role.Values.BASIC.name());

        var userDb = userRepository.findByUsername(basicRole.getName());
        if (userDb.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var user = new User();
        user.setName(dto.name());
        user.setUsername(dto.username());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRole(Set.of(basicRole));
        userRepository.save(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuário criado com sucesso");

        return ResponseEntity.ok().build();
    }

    @Transactional
    public User update(User user) {
        User updateUser = findById(user.getId());
        updateUser.setName(user.getName());
        updateUser.setPassword(user.getPassword());
        return this.userRepository.save(updateUser);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.userRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Não é possível excluir Usuario, há dependencias.");
        }
    }
}
