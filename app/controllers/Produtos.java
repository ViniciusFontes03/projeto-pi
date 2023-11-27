package controllers;

import java.util.List;

import models.Produto;
import models.Usuario;
import play.mvc.Controller;

public class Produtos extends Controller{
    
    public static void form() {
        render();
    }

    public static void cadastrar(Produto prod) {
        prod.save();
        listar();
    }

    public static void listar() {
        List<Produto> pdt = Produto.findAll();
        render(pdt);
    }
    public static void editar(Long id) {
        Produto prod = Produto.findById(id);
		renderTemplate("Produtos/form.html", prod);
    }

    public static void deletar(Long id) {
        Produto produto = Produto.findById(id);
		produto.delete();
		listar();
    }
    
}
