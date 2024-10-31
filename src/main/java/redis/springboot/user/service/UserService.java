package redis.springboot.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.springboot.user.model.entity.User;
import redis.springboot.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Criar usuário
    public void createUser(User user) {
        userRepository.save(user);
    }

    // Encontrar usuário por CPF
    public User getUserByCpf(String cpf) {
        return userRepository.findById(cpf);
    }
}