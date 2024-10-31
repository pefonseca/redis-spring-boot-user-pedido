package redis.springboot.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.springboot.user.model.entity.Pedido;
import redis.springboot.user.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public String createUser(@RequestBody Pedido pedido) {
        pedidoService.createUser(pedido);
        return "Usuário salvo com sucesso!";
    }

    @GetMapping("/{pedido}")
    public Pedido getUserByCpf(@PathVariable Long pedido) {
        return pedidoService.getUserByCpf(pedido);
    }

}
