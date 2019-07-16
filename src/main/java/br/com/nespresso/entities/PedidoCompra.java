package br.com.nespresso.entities;

import java.util.Date;

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
@Table(name = "pedidos_compras")
public class PedidoCompra {
	
	@Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "int")
    private Integer codigo;
	
	@NotNull
	@Column(name = "data_compra", columnDefinition = "datetime")
	private Date dataPedido;
	
	@ManyToOne
	 @JoinColumn(name = "fk_cliente", columnDefinition = "int")
	 private Cliente fkCliente;
	
	

}
