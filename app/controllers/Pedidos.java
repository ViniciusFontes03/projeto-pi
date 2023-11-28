package controllers;

import java.util.List;

import models.Pedido;
import models.Usuario;
import play.mvc.Controller;

public class Pedidos extends Controller{
    
    public static void form() {
        render();
    }

    public static void cadastrar(Pedido p) {
        p.save();
        listar();
    }
    
    public static void listar() {
    	List<Pedido> pedido = Pedido.findAll();
    	render(pedido);
    }

    
}
