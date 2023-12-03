package models;

import java.util.List;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Cliente extends Model{
    public String nome;
    public String endereco;

}
