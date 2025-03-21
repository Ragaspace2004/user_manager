package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
//    private List<User> users = new ArrayList<>();
    @Autowired
    private UserRepository users;

    public String addUser(User user) {
        users.save(user);
        return "User added successfully: " + user.getName();
    }

    public List<User> getUsers() {
        return users.findAll();
    }

    //GET BY ID
    public String getUser(Integer id) {
        User user = users.findById(id).orElse(null);
        if (user != null) {
            return "User found: " + user.getName();
        } else {
            return "User not found";
        }
    }
    public String deleteAll(){
        users.deleteAll();
        return "All users deleted successfully";
    }
    public String update(User user){
        users.save(user);
        return "User updated successfully";
    }
    public String delete(Integer id){
        users.deleteById(id);
        return "User deleted successfully";
    }


}
