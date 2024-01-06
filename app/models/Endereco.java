package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Endereco extends Model {
    @Required
    public String cep;

    @Required
    public String logradouro;

    @ManyToOne(cascade=CascadeType.PERSIST)
    public Bairro bairro;
}
