package br.com.nespresso.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "tamanho_preparo")
public class TamanhoPreparo {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "tinyint")
    private int codigo;

    @NotNull
    @Size(max = 255)
    @Column(name = "nome", columnDefinition = "varchar(255)")
    private String nome;

    @NotNull
    @Column(name = "tamanho", columnDefinition = "tinyint")
    private int tamanho;

    @NotNull
    @Size(max = 3)
    @Column(name = "medida", columnDefinition = "char(3)")
    private String medida;
    
    public TamanhoPreparo() {
    	super();
    }
    
    public TamanhoPreparo(int id) {
    	this();
    	this.setCodigo(id);
    }
}
