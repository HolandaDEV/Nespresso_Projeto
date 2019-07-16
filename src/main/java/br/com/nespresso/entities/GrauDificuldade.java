package br.com.nespresso.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "receita_graus_dificuldades")
public class GrauDificuldade {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "smallint")
    private Integer codigo;

    @NotNull
    @Column(name = "grau", columnDefinition = "varchar(255)")
    private String descricao;

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
