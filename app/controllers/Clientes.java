package controllers;

import models.Cliente;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Clientes extends Controller{
    public static void form(){
        render();
    }
    public static void cadastrar(Cliente cli) {
        cli.save();
        Produtos.listar();
    }
    public static void editar(Long id) {
		Cliente c = Cliente.findById(id);
		flash.put("c.id", c.id);
		flash.put("c.nome", c.nome);
		flash.put("c.endereco", c.endereco);
		form();	
	}
}
