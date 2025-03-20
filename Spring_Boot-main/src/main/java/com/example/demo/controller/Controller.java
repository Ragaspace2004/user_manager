package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public String UserCreation(@RequestBody User user1) {
        return userService.addUser(user1);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getUsers();
    }

//    @GetMapping("/get/{id}")
//    public String getUser(@PathVariable Integer id) {
//        return userService.getUser(id);
//    }
    @DeleteMapping("/delete")
    public String deleteAll() {
        return userService.deleteAll();
    }
    @PutMapping("/update")
    public String update(@RequestBody User user) {
        return userService.update(user);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return userService.delete(id);
    }
    @GetMapping("/get/{id}")
    public String get(@PathVariable Integer id) {
        return userService.getUser(id);
    }
}