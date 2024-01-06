package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Bairro extends Model{

    public Bairro(String bairro, Cidade c) {
		nome = bairro;
		cidade = c;
	}
    @Required
    public String nome;

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Cidade cidade;
}
