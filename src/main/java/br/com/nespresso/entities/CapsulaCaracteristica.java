package br.com.nespresso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "capsulas_caracteristicas")
public class CapsulaCaracteristica {
	
	@Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "int")
    private Integer codigo;
	
	@ManyToOne
    @JoinColumn(name = "fk_capsula", columnDefinition = "int")
	private Capsula capsula;
	
	@ManyToOne
    @JoinColumn(name = "fk_caracteristica", columnDefinition = "tinyint")
	private Caracteristica caracteristica;
	
	@NotNull
	@Column(name = "valor_caracteristica", columnDefinition = "tinyint")
	private Short valorCaracteristica;
	
	
	public CapsulaCaracteristica() {
		super();
	}
	
	public CapsulaCaracteristica(Capsula capsula, Caracteristica caracteristica,Short valor) {
		this();
		this.capsula = capsula;
		this.caracteristica = caracteristica;
		this.valorCaracteristica = valor;
	}
	
	
	
	
	

}
