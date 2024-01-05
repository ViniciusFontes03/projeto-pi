package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Produto extends Model {
    public String nome;
    public Float preco;
    public int estoqueAgua;
    public int estoqueGas;
}
