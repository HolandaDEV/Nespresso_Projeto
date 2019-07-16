package br.com.nespresso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "capsulas_aromaticos")
public class CapsulaPerfilAromatico {
	
	
	@Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "int")
    private Integer codigo;
	
	@ManyToOne
    @JoinColumn(name = "fk_capsula", columnDefinition = "int")
	private Capsula capsula;
	
	@ManyToOne
    @JoinColumn(name = "fk_perfilaromatico", columnDefinition = "int")
	private PerfilAromatico perfilAromatico;
	
	public CapsulaPerfilAromatico() {
		super();
	}
	
	public CapsulaPerfilAromatico(Capsula capsula, PerfilAromatico pAromatico) {
		this();
		this.capsula = capsula;
		this.perfilAromatico = pAromatico;
	}

}
