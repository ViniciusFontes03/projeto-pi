package controllers;

import java.util.List;

import models.Cliente;
import models.Pedido;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Pedidos extends Controller{
    
    public static void form() {
    	List <Cliente> cliLista = Cliente.findAll();
        render(cliLista);
    }

    public static void cadastrar(Pedido p, Long idCliente) {

        if (idCliente != null) {
            Cliente cli = Cliente.findById(idCliente);
            cli.pedidoCliente.add(cli);
        }
        
        p.save();
        listar();
    }
    
    public static void listar() {
     List<Pedido> pedido = Pedido.findAll();
     long totalPedidos = Pedido.count();
    	render(pedido,totalPedidos);
    }

    
}
