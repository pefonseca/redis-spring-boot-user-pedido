package redis.springboot.user.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import redis.springboot.user.model.entity.Pedido;

@Repository
public class PedidoRepository {

    private static final String KEY = "PEDIDO"; // Corrigido para "PEDIDO"

    @Autowired
    private RedisTemplate<String, Pedido> redisTemplate;

    private HashOperations<String, Long, Pedido> hashOperations;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    // Salvar pedido
    public void save(Pedido pedido) {
        hashOperations.put(KEY, pedido.getPedido(), pedido); // pedido.getPedido() é Long
    }

    // Encontrar pedido pelo ID
    public Pedido findById(Long pedido) {
        return hashOperations.get(KEY, pedido); // pedido é Long
    }
}
