package br.com.nespresso.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "receitas_capsulas")
public class ReceitaCapsula {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "smallint")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "fk_receita", columnDefinition = "smallint")
    private Receita receita;

    @ManyToOne
    @JoinColumn(name = "fk_capsula", columnDefinition = "int")
    private Capsula capsula;

    public ReceitaCapsula(){
        super();
    }

    public ReceitaCapsula(Capsula pCapsula, Receita pReceita) {
        this();

        this.capsula = pCapsula;
        this.receita = pReceita;
    }
}
