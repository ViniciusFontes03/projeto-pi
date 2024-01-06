package controllers;

import java.util.List;

import models.Bairro;
import models.Cidade;
import models.Endereco;
import models.UF;
import play.mvc.Controller;

public class Enderecos extends Controller {

	public static void cep(String cep){
		
		Endereco end = Endereco.find("cep = ?", cep).first();
		
		renderJSON(end);
		
	}
	
	public static void cidade(String query, String uf){
		
		List<Cidade> lista = Cidade.find("lower(nome) like lower(?1) and uf = ?2",
									"%"+query+"%", UF.valueOf(uf)
								).fetch();
		
		renderJSON(lista);
	}
	
	public static void bairro(String query, String uf, String cidade){
		
		Cidade c = Cidade.find("lower(nome) = lower(?1) and uf = ?2",
								cidade, UF.valueOf(uf)
							).first();
		
		
		
		List<String> lista = Bairro.find("select b.nome from Bairro b "
										+ " where lower(b.nome) like lower(?1) "
										+ " and b.cidade.id = ?2", 
										"%"+query+"%", c.id).fetch();
		
		
		renderJSON(lista);
	}
	
}
