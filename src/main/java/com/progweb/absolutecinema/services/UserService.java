package com.progweb.absolutecinema.services;

import com.progweb.absolutecinema.model.User;
import com.progweb.absolutecinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
    public User create(User user){
        user.setId(null);
        return user = this.userRepository.save(user);
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
