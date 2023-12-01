package controllers;

import models.Produto;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Login extends Controller{
	
	public static void form() {
		render();
	}
	
	public static void entrar(String email, String senha) {
		Usuario usu = Usuario.find("email = ?1 and senha = ?2", email, senha).first();
		
		if (usu == null) {
			form();
		} else {
			session.put("usuario.email", usu.email);
			session.put("usuario.email", usu.senha);
			
			Pedidos.form();
		}
	}
	
	public static void sair() {
		session.clear();
		Login.form();
	}
}