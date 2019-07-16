package br.com.nespresso.entities;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "int")
    private int codigo;

    @NotNull
    @Size(max = 255)
    @Column(name = "nome", columnDefinition = "varchar(255)")
    private String nome;

}
