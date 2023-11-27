package controllers;

import models.Usuario;
import play.mvc.Controller;

public class Login extends Controller{
	
	public static void form() {
		render();
	}
	
	public static void teste() {
		Usuario adm = new Usuario();
		adm.email = "adm@adm.com";
		adm.senha = "adm";
		adm.nome = "adm";
		
		adm.save();
		
		form();
	}
	
	public static void entrar(String email, String senha) {
		Usuario usu = Usuario.find("email = ?1 and senha = ?2", email, senha).first();
		
		if (usu == null) {
			form();
		} else {
			session.put("usuario.email", usu.email);
			session.put("usuario.email", usu.senha);
			
			Produtos.form();
		}
		
		
	}
	
	public static void sair() {
		session.clear();
		Login.form();
	}
}