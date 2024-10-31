package redis.springboot.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.springboot.user.model.entity.Pedido;
import redis.springboot.user.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Criar usuário
    public void createUser(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    // Encontrar usuário por CPF
    public Pedido getUserByCpf(Long pedido) {
        return pedidoRepository.findById(pedido);
    }

}
