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
        Cache.clear();
        render(cliLista);
    }

    public static void cadastrar(@Valid Pedido p, Long idCliente) {

         if (idCliente != null) {
            Cliente cli = Cliente.findById(idCliente);
            cli.pedidoCliente.add(cli);
        }

    	if (validation.hasErrors()) {
    		validation.keep();
            flash.error("Campos obrigatorios!");
    		Cache.set("p", p);
    		form();
    	} else{
            flash.success("Pedido registrado!!");
                p.save();
                 listar();
        }
       
    }
    
    
    public static void listar() {
        
        String filtro = params.get("filtro");

    List<Pedido> listaPed;
        if (filtro == null || filtro.isEmpty()) {
            listaPed = Pedido.findAll();
        } else{
            listaPed = Pedido.find("nome like ?1 or endereco like ?1 ", 
            "%"+ filtro +"%").fetch();
        }

        long totalPedidos = Pedido.count();
    	render(listaPed,totalPedidos);
    }
    public static void editar(long id) {
        Pedido p = Pedido.findById(id);
        List<Cliente> cliLista = Cliente.findAll();
        renderTemplate("Pedidos/form.html", p, cliLista);
        
    }

    public static void delete(long id){
        Pedido p = Pedido.findById(id);
        p.delete();
        flash.success("Removido com sucesso!!");
        listar();
    
    }
}