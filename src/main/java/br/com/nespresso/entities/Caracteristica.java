package br.com.nespresso.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "caracteristicas")
public class Caracteristica {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "tinyint")
    private int codigo;

    @NotNull
    @Size(max = 255)
    @Column(name = "nome", columnDefinition = "varchar(255)")
    private String nome;

    @NotNull
    @Column(name = "grau_maximo", columnDefinition = "tinyint")
    private int grauMaximo;
    
    public Caracteristica() {
    	super();
    }
    
    public Caracteristica(int id) {
    	this();
    	this.codigo = id;
    }
    
}
