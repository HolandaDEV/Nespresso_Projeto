drop database if exists nespresso;

create database nespresso;
use nespresso;

create table categorias(
	id int not null primary key auto_increment,
    nome varchar(255) not null unique
);

insert into categorias(nome) values
('Edição Limitada'),('Intenso'), ('Espresso'),('Master Origin'), ('Lungo'), ('Decaffeinato'),('Variations');

create table perfil_aromatico(
	id tinyint not null primary key auto_increment,
    nome varchar(255) not null unique
);

insert into perfil_aromatico(nome) values('Apimentado'),('Woody'),('Vinho'),('Frutado'),('Doce'), ('Mel');

create table caracteristicas(
	id tinyint not null primary key auto_increment,
    nome varchar(255) not null unique,
    grau_maximo tinyint not null
);

insert into caracteristicas(nome, grau_maximo) values('Intensidade',12),('Amargor',5),('Acidez',5),('Corpo',5),('Torra',5);

create table tamanho_preparo(
	id tinyint not null primary key auto_increment,
    nome varchar(255) not null unique,
    tamanho tinyint not null unique,
    medida char(3) not null
);

insert into tamanho_preparo(nome, tamanho, medida) values('Espresso', 40, 'ML'),('Lungo', 110, 'ML');

create table capsulas(
	id int not null primary key auto_increment,
    nome varchar(255) not null unique,
    complemento_nome varchar(255) null,
	preco decimal(6,2) not null,
    qtde_unitaria tinyint not null,
    habilitado bit not null default 1,
    fk_categoria int references categorias(id)
);

insert into capsulas(nome, complemento_nome, preco, qtde_unitaria, habilitado, fk_categoria) values
('India', 'com Robusta Monsoon', '2.50', 1, 1, 4),
('Indonesia', 'com Arábicas no método descascamento úmido', '2.50', 1, 1, 4),
('Colombia', 'com Arabica de colheita Tardia', '2.50', 1, 1, 4),
('Nicaragua', 'com Arabica “Black-Honey”', '2.50', 1, 1, 4),
('Ethiopia', 'com Arabica de secagem natural', '2.50', 1, 1, 4);

create table capsulas_tamanho(
	id int not null primary key auto_increment,
    fk_capsula int not null references capsulas(id),
    fk_tamanho tinyint not null references tamanho_preparo(id)
);

insert into capsulas_tamanho(fk_capsula, fk_tamanho) values
(1,1),(1,2),(2,1),(2,2),(3,1),(3,2),(4,1),(4,2),(5,1),(5,2);

create table capsulas_aromaticos(
	id int not null primary key auto_increment,
    fk_capsula int not null references capsulas(id),
    fk_perfilaromatico tinyint not null references perfil_aromatico(id)
);

insert into capsulas_aromaticos(fk_capsula, fk_perfilaromatico) values
(1,1),(2,2),(3,3),(3,4),(4,5),(4,6),(5,3),(5,4);

create table capsulas_caracteristicas(
	id int not null primary key auto_increment,
    fk_capsula int not null references capsulas(id),
    fk_caracteristica tinyint not null references caracteristicas(id),
    valor_caracteristica tinyint not null
);

insert into capsulas_caracteristicas(fk_capsula, fk_caracteristica, valor_caracteristica) values
(1,1,11),(1,2,5),(1,3,1),(1,4,4),(1,5,5),
(2,1,8),(2,2,3),(2,3,2),(2,4,4),(2,5,4),
(3,1,6),(3,2,3),(3,3,4),(3,4,3),(3,5,3),
(4,1,5),(4,2,2),(4,3,2),(4,4,2),(4,5,2),
(5,1,4),(5,2,2),(5,3,4),(5,4,2),(5,5,2);


