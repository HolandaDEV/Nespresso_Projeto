package br.com.nespresso.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "receitas_ingredientes")
public class Ingrediente {
	
	@Id
	@GeneratedValue
	@Column(name = "id", columnDefinition = "int")
	private Integer codigo;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "ingrediente", columnDefinition = "varchar(255)")
	private String nomeIngrediente;
	
	@ManyToOne
    @JoinColumn(name = "fk_receita", columnDefinition = "int")
    private Receita receita;
	
	public Ingrediente() {
		super();
	}
	
	public Ingrediente(String nome, Receita receita) {
		this();
		this.nomeIngrediente = nome;
		this.receita = receita;
	}
}