package br.com.nespresso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "pedidos_compras_itens")
public class itensPedidos {
	
	@Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "int")
    private Integer codigo;
	
	@NotNull
    @Column(name = "quantidade", columnDefinition = "tinyint")
    private short quantidadeUnitaria;
	
	@NotNull
    @Column(name = "preco", columnDefinition = "decimal(6,2)")
    private Double preco;
	
	@ManyToOne
    @JoinColumn(name = "fk_capsula", columnDefinition = "int")
    private Capsula fkIdCapsula;
	
	@ManyToOne
    @JoinColumn(name = "fk_pedido_compra", columnDefinition = "int")
    private PedidoCompra fkIdPedido ;

}
