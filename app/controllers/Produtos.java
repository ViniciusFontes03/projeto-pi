package controllers;

import java.util.List;

import models.Produto;
import models.Produto;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Produtos extends Controller{
    
    public static void form() {
        render();
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
