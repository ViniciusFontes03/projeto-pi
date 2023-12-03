package models;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Cliente extends Model{
    public String nome;
    public String endereco;

    @OneToMany
    @JoinColumn(name = "idCliente")
    public List<Cliente> pedidoCliente;
}
