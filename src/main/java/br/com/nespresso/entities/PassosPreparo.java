package br.com.nespresso.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "receitas_passos")
public class PassosPreparo {
	
	@Id
	@GeneratedValue
	@Column(name = "id", columnDefinition = "int")
	private Integer codigo;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "passo", columnDefinition = "varchar(255)")
	private String descricaoPassos;
	
	@ManyToOne
    @JoinColumn(name = "fk_receita", columnDefinition = "int")
    private Receita receita;
	
	public PassosPreparo() {
	super ();	
	}
	
	public PassosPreparo(String descricao, Receita receita) {
		this();
		this.descricaoPassos = descricao;
		this.receita = receita;
	}
}