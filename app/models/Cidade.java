package models;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Cidade extends Model {

    public Cidade(String cidade, UF uf2) {
		
		nome = cidade;
		uf = uf2;
		
	}
    @Required
    public String nome;

    @Required
    public UF uf;
}
