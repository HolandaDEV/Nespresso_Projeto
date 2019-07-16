package br.com.nespresso.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "usuarios", catalog = "nespresso")
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "int")
    private Integer codigo;

    @NotNull
    @Size(max = 255)
    @Column(name = "login", columnDefinition = "varchar(255)")
    private String login;

    @NotNull
    @Size(max = 255)
    @Column(name = "senha", columnDefinition = "varchar(255)")
    private String senha;

    @ManyToOne
    @JoinColumn(name = "fk_cliente", columnDefinition = "int")
    private Cliente cliente;
}
