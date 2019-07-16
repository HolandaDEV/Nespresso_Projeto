package br.com.nespresso.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "receitas_palavras_chaves")
public class Keyword {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "int")
    private Integer codigo;

    @Size(max = 255)
    @Column(name = "palavra_chave", columnDefinition = "varchar(255)")
    private String palavra;

    @ManyToOne
    @JoinColumn(name = "fk_receita", columnDefinition = "smallint")
    private Receita receita;

    public Keyword(){
        super();
    }

    public Keyword(String paramPalavra, Receita paramReceita) {
        this();
        this.palavra = paramPalavra;
        this.receita = paramReceita;
    }
}
