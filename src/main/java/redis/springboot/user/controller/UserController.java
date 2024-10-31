package redis.springboot.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.springboot.user.model.entity.User;
import redis.springboot.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "Usuário salvo com sucesso!";
    }

    @GetMapping("/{cpf}")
    public User getUserByCpf(@PathVariable String cpf) {
        return userService.getUserByCpf(cpf);
    }
}