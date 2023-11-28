package controllers;

import models.Produto;
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
		
		Produto agua = new Produto();
		agua.nome = "Garrafão de água 20L";
		agua.preco = 7;
		agua.save();
		
		Produto gas = new Produto();
		gas.nome = "Botijão de gás 13kg";
		gas.preco = 100;
		gas.save();
		
		form();
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