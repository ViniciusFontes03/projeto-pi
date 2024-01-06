package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.validation.Min;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Pedido extends Model {
	
	@Required
    public String nome;
	
    @Required
    public String numero;

	@Required
	@Min(0)
    public Integer qntdAgua;
	
	@Min(0)
	@Required
    public Float valorAgua;
	
	@Min(0)
	@Required
    public Integer qntdGas;
	
	@Min(0)
	@Required
    public Float valorGas;
    

    public Date data;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    public Cliente cliente;

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Endereco endereco;
}