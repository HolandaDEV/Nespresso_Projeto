package br.com.nespresso.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "receitas")
public class Receita {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "int")
    private Integer codigo;


    @NotNull
    @Size(max = 255)
    @Column(columnDefinition = "varchar(255)")
    private String nome;

    @NotNull
    @Size(max = 255)
    @Column(columnDefinition = "varchar(255)")
    private String descricao;

    @NotNull
    @Column(columnDefinition = "time", name = "tempo_preparo")
    private Timestamp tempoPreparo;

    @NotNull
    @Column(columnDefinition = "tinyint", name = "rendimento")
    private int rendimento;

    @ManyToOne
    @JoinColumn(name = "fk_grau_dificuldade", columnDefinition = "tinyint")
    private GrauDificuldade grauDificuldade;

    @OneToMany(mappedBy = "receita", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ReceitaCapsula> capsulas = new ArrayList<>();


    @OneToMany(mappedBy = "receita", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Keyword> keywords = new ArrayList<>();

    @OneToMany(mappedBy = "receita", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ingrediente> ingredientes = new ArrayList<>();

    @OneToMany(mappedBy = "receita", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PassosPreparo> passosPreparo = new ArrayList<>();
}