package br.com.nespresso.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Data
@Entity
@Table(name = "clientes", catalog = "nespresso")
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "int")
    private Integer codigo;

    @NotNull
    @Size(max = 255)
    @Column(name = "nome", columnDefinition = "varchar(255)")
    private String nome;

    @NotNull
    @Size(max = 255)
    @Column(name = "sobrenome", columnDefinition = "varchar(255)")
    private String sobrenome;

    @NotNull
    @Column(name = "data_cadastro", columnDefinition = "datetime")
    private Calendar dataCadastro;
}
