package controllers;

import javax.validation.Valid;

import models.Cliente;
import play.cache.Cache;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Clientes extends Controller{
    public static void form(){
        render();
    }
    public static void cadastrar(@Valid Cliente cli) {
        
        if (validation.hasErrors()) {
    		validation.keep();
            flash.error("Campos obrigatorios!");
    		Cache.set("cli", cli);
    		form();
    	} else{
            flash.success("Pedido registrado!!");
            cli.save();
        Pedidos.listar();
        }
        
    }
    public static void editar(Long id) {
		Cliente c = Cliente.findById(id);
		flash.put("c.id", c.id);
		flash.put("c.nome", c.nome);
		flash.put("c.endereco", c.endereco);
		form();	
	}
}
