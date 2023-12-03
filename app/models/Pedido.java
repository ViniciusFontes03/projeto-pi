package models;

import java.util.Date;
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
    public double valorAgua;
    public int qntdGas;
    public double valorGas;
    public Date data;

    @OneToMany
    @JoinColumn(name = "idCliente")
    public List<Cliente> pedidoCliente;
}