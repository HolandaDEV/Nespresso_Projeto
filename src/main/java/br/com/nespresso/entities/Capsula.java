package br.com.nespresso.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "capsulas")
public class Capsula {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "int")
    private Integer codigo;

    @NotNull
    @Size(max = 255)
    @Column(name = "nome", columnDefinition = "varchar(255)")
    private String nome;

    @Size(max = 255)
    @Column(name = "complemento_nome", columnDefinition = "varchar(255)")
    private String complementoNome;

    @NotNull
    @Column(name = "preco", columnDefinition = "decimal(6,2)")
    private Double preco;

    @NotNull
    @Column(name = "qtde_unitaria", columnDefinition = "tinyint")
    private short quantidadeUnitaria;

    @Column(name = "habilitado", columnDefinition = "bit")
    private boolean habilitado;

    @ManyToOne
    @JoinColumn(name = "fk_categoria", columnDefinition = "int")
    private Categoria categoria;

    @OneToMany(mappedBy = "receita")
    private List<ReceitaCapsula> receitas;
    
    @OneToMany(mappedBy = "capsula", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CapsulaCaracteristica> caracteristica = new ArrayList<>();
    
    @OneToMany(mappedBy = "capsula", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CapsulaPerfilAromatico> perfilAromatico = new ArrayList<>();

    @OneToMany(mappedBy = "capsula", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CapsulaTamanhoPreparo> tamanhoPreparo = new ArrayList<>();
    
    public Capsula() {
        super();
    }

    public Capsula(int codigo) {
        this();
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public short getQuantidadeUnitaria() {
        return quantidadeUnitaria;
    }
}
