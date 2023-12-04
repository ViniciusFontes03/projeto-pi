package models;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Cliente extends Model{
    @Required
    public String nome;
    @Required
    public String endereco;

    @OneToMany
    @JoinColumn(name = "idCliente")
    public List<Cliente> pedidoCliente;
}
