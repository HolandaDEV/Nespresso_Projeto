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
@Table(name = "capsulas_tamanho")
public class CapsulaTamanhoPreparo {
	
	@Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "int")
    private Integer codigo;
	
	@ManyToOne
    @JoinColumn(name = "fk_capsula", columnDefinition = "int")
	private Capsula capsula;
	
	@ManyToOne
    @JoinColumn(name = "fk_tamanho", columnDefinition = "int")
	private TamanhoPreparo tamnhoPreparo;
	
	public CapsulaTamanhoPreparo() {
		super();
	}
	
	public CapsulaTamanhoPreparo(Capsula capsula, TamanhoPreparo tPreparo) {
		this();
		this.capsula = capsula;
		this.tamnhoPreparo =tPreparo;
	}

}
