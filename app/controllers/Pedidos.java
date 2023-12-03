package controllers;

import java.util.List;


import models.Cliente;
import models.Pedido;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Pedidos extends Controller{
    
    public static void form() {
    	List <Cliente> cliLista = Cliente.findAll();
    	Pedido p = (Pedido) Cache.get("p");
        render(cliLista);
    }

    public static void cadastrar(@Valid Pedido p, Long idCliente) {

    	if (validation.hasErrors()) {
    		validation.keep();
    		Cache.set("p", p);
    		form();
    	}
    	
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

    public static void editar(long id) {
        Pedido p = Pedido.findById(id);
        renderTemplate("Pedidos/form.html", p);
        
    }

    public static void delete(long id){
        Pedido p = Pedido.findById(id);
        p.delete();
        listar();
    
}
}