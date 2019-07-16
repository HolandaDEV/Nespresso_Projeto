use nespresso;

create table clientes(
	id int not null primary key auto_increment,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    data_cadastro datetime not null
);

insert into clientes(nome, sobrenome, data_cadastro)
	values('Weldevan', 'de Carvalho', now()),
    ('Alice', 'dos Santos', now()),
    ('Fabiano', 'dos Santos', now()),
    ('João Vitor', 'Chichurra', now()),
    ('Nathan', 'Santos', now()),
    ('Lucas', 'Lima', now()),
    ('Gabriel', 'Oliveira', now()),
    ('Victor', 'Matos', now()),
    ('Thiago', 'Andrade', now()),
    ('Dieime Ricardo', 'Vieira', now()),
    ('João Victor', 'Santos', now()),
    ('Eduardo', 'Timoteo', now()),
    ('Pedro', 'Conceição', now()),
    ('Felipe', 'de Oliveira', now()),
    ('Allan', 'Jhordan', now()),
    ('Henrique', 'Amorim', now()),
    ('Vitor', 'Augusto', now()),
    ('Mikael', 'Silva', now()),
    ('Jean', 'Luengo', now()),
    ('Vitor', 'Casimiro', now()),
    ('Michael', 'Amaral', now()),
    ('Frank', 'Roman', now()),
    ('Erick', 'Silva', now());
    
create table usuarios(
	id int not null primary key auto_increment,
    login varchar(255) not null unique,
    senha varchar(255) not null,
    fk_cliente int not null,
    constraint fk_usuario_cliente 
		foreign key(fk_cliente) references clientes(id)
);

insert into usuarios(login, senha, fk_cliente)
	values('thiago.nascimento', '123qwe', 9),
    ('joao.chichurra', '123qwe', 4),
    ('alice.santos', '123qwe', 2),
    ('vitor.augusto', '123qwe', 17);
    
create table pedidos_compras(
	id int not null primary key auto_increment,
    data_compra datetime not null,
    fk_cliente int not null,
    constraint fk_pedidos_compras_clientes foreign key(fk_cliente)
		references clientes(id)
);

insert into pedidos_compras(data_compra, fk_cliente)
	values(now(), 9);

create table pedidos_compras_itens(
	id int not null primary key auto_increment,
    fk_pedido_compra int not null,
    fk_capsula int not null,
    quantidade tinyint not null,
    preco decimal(6,2) not null,
    constraint fk_pedidos_compras_itens_capsulas foreign key(fk_capsula)
		references capsulas(id),
	constraint fk_pedidos_compras_itens_pedidos_compras foreign key(fk_pedido_compra)
		references pedidos_compras(id)
);

insert into pedidos_compras_itens(fk_pedido_compra, fk_capsula, quantidade, preco)
	values(1,5,2,2.50),(1,3,3,2.50),(1,4,3,2.50),(1,5,2,2.50);

/*
select cl.nome, cl.sobrenome
	from pedidos_compras_itens pci
		inner join capsulas c on c.id = pci.fk_capsula
        inner join pedidos_compras pc on pc.id = pci.fk_pedido_compra
        inner join clientes cl on cl.id = pc.fk_cliente;

*/








