package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import org.apache.commons.validator.routines.EmailValidator;

@Service
public class UserService {

    @Autowired
    private UserRepository users;

    public String addUser(User user) {
        if (user == null) {
            return "User object cannot be null";
        }
        if (StringUtils.isEmpty(user.getName())) {
            return "User name cannot be empty";
        }
        if (StringUtils.isEmpty(user.getEmail())) {
            return "User email cannot be empty";
        }
        if(!EmailValidator.getInstance().isValid(user.getEmail())){
            return "Invalid email";
        }
        users.save(user);
        return "User added successfully: " + user.getName();
    }

    public List<User> getUsers() {
        return users.findAll();
    }

    public String getUser(Integer id) {
        if (id == null) {
            return "ID cannot be null";
        }
        Optional<User> userOptional = users.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return "User found: " + user.getName();
        } else {
            return "User not found";
        }
    }


    public String deleteAll() {
        users.deleteAll();
        return "All users deleted successfully";
    }

    public String update(User user) {
        if (user == null) {
            return "User object cannot be null";
        }
        if (user.getId() == null) {
            return "User ID cannot be null for update";
        }
        if (!users.existsById(user.getId())) {
            return "User with ID " + user.getId() + " not found";
        }
        users.save(user);
        return "User updated successfully";
    }

    public String delete(Integer id) {
        if (id == null) {
            return "ID cannot be null";
        }
        if (!users.existsById(id)) {
            return "User with ID " + id + " not found";
        }
        users.deleteById(id);
        return "User deleted successfully";
    }
}
