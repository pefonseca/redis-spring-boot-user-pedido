package redis.springboot.user.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import redis.springboot.user.model.entity.User;

import java.util.Map;

@Repository
public class UserRepository {

    private static final String KEY = "USER";

    @Autowired
    @Qualifier("userRedisTemplate")
    private RedisTemplate<String, User> redisTemplate;
    @Autowired
    private HashOperations<String, String, User> hashOperations;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    // Salvar usuário
    public void save(User user) {
        hashOperations.put(KEY, user.getCpf(), user);
    }

    // Encontrar usuário pelo CPF
    public User findById(String cpf) {
        return hashOperations.get(KEY, cpf);
    }

    // Buscar todos os usuários
    public Map<String, User> findAll() {
        return hashOperations.entries(KEY);
    }

    // Atualizar usuário
    public void update(User user) {
        save(user);  // Salva o usuário com as novas informações
    }

    // Deletar usuário pelo CPF
    public void delete(String cpf) {
        hashOperations.delete(KEY, cpf);
    }

}
