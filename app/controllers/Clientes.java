package controllers;

import models.Cliente;
import play.mvc.Controller;

public class Clientes extends Controller{
    public static void form(){
        form();
    }
    public static void cadastrar(Cliente cli) {
        cli.save();
        Produtos.listar();
    }
}
