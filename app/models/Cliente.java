package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Cliente extends Model{
    @Required
    public String nome;

    @Required
    public String numero;
    
    @OneToMany
    @JoinColumn(name = "idCliente")
    public List<Pedido> pedidoCliente;

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Endereco endereco;
}
