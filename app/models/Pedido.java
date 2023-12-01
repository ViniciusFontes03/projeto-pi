package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Pedido extends Model {
    public String nome;
    public String endereco;
    public int qntdAgua;
    public int qntdGas;
    public double valor;

    @OneToMany
    @JoinColumn(name = "idCliente")
    public List<Cliente> pedidoCliente;
}