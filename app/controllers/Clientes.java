package controllers;

<<<<<<< HEAD
import javax.validation.Valid;

import models.Cliente;
import play.cache.Cache;
=======
import java.util.List;

import models.Cliente;
import models.Produto;
>>>>>>> 0162845c8145e91381f4a33b7003f0f8b18cf0e9
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
        Cliente cli = Cliente.findById(id);
		renderTemplate("Clientes/form.html", cli);
    }

    public static void listar() {
        List<Cliente> listaDeClientes = Cliente.findAll();
        render(listaDeClientes);
    }
    public static void deletar(Long id) {
        Cliente cli = Cliente.findById(id);
		cli.delete();
		listar();
    }
}
