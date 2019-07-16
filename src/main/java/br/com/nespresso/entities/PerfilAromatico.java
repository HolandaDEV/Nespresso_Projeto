package br.com.nespresso.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "perfil_aromatico")
public class PerfilAromatico {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "tinyint")
    private int codigo;

    @NotNull
    @Size(max = 255)
    @Column(name = "nome", columnDefinition = "varchar(255)")
    private String nome;
    
    public PerfilAromatico() {
    	super();
    }
    
    public PerfilAromatico(int id) {
    	this();
    	this.setCodigo(id);
    }
}
