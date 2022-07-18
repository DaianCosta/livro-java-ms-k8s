package com.dc.java.back.end.controller;

import com.dc.java.back.end.dto.UserDTO;
import com.dc.java.back.end.exception.UserNotFoundException;
import com.dc.java.back.end.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/")
    public List<UserDTO> getUsers() {
        List<UserDTO> usuarios = userService.getAll();
        return usuarios;
    }

    @GetMapping("/user/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    public UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping("/user/cpf/{cpf}")
    public UserDTO findByCpf(@RequestParam(name = "key") String key, @PathVariable String cpf) {
        return userService.findByCpf(cpf, key);
    }

    @DeleteMapping("/user/{id}")
    public UserDTO delete(@PathVariable Long id) throws UserNotFoundException {
        return userService.delete(id);
    }

    @GetMapping("/user/search")
    public List<UserDTO> queryByName(@RequestParam(name = "nome", required = true) String nome) {
        return userService.queryByName(nome);
    }

}
