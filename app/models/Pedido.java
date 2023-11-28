package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Pedido extends Model {
    public String nome;
    public String endereco;
    public int qntdAgua;
    public int qntdGas;
    public double valor;
}