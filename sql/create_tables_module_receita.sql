use nespresso;

create table receita_graus_dificuldades(
	id tinyint primary key auto_increment,
    grau varchar(255) not null
);

insert into receita_graus_dificuldades(grau)
values('Fácil'), ('Médio'), ('Difícil');

create table receitas(
	id smallint primary key auto_increment,
    nome varchar(255) not null,
    descricao varchar(255) not null,
    tempo_preparo time not null,
    rendimento tinyint not null,
    fk_grau_dificuldade tinyint not null,
    constraint fk_receita_grau_dificuldade
		foreign key (fk_grau_dificuldade) 
        references receita_graus_dificuldades(id)
);

insert into receitas(nome, descricao, tempo_preparo, rendimento, fk_grau_dificuldade)
values('Café Tropical com Manga', 
'O caráter intenso dos cafés e a força dos aromas tropicais da manga e do chocolate se juntam num momento exótico.',
'00:05:00', 1, 1);

create table receitas_capsulas(
	id smallint not null primary key auto_increment,
    fk_capsula int not null,
    fk_receita smallint not null,
    constraint fk_receitas_capsulas_capsula foreign key(fk_capsula)
		references capsulas(id),
	constraint fk_receitas_capsulas_receita foreign key(fk_receita)
		references receitas(id)
);

insert into receitas_capsulas(fk_capsula, fk_receita)
values(1, 1),(7, 1), (6, 1), (8, 1);

create table receitas_palavras_chaves(
	id int not null primary key auto_increment,
    palavra_chave varchar(255) not null,
    fk_receita smallint not null,
    constraint fk_receitas_palavras_chaves foreign key(fk_receita)
		references receitas(id)
);

insert into receitas_palavras_chaves(palavra_chave, fk_receita)
values('Manga', 1),('Wafer', 1);

create table receitas_ingredientes(
	id int not null primary key auto_increment,
    ingrediente varchar(255) not null,
    fk_receita smallint not null,
    constraint fk_receitas_ingredientes foreign key(fk_receita)
		references receitas(id)
);

insert into receitas_ingredientes(ingrediente, fk_receita)
values('1 cápsula', 1),
('Suco de manga', 1),
('Cubos de gelo ou gelo triturado', 1),
('Leite', 1);

create table receitas_passos(
	id int not null primary key auto_increment,
    passo varchar(255) not null,
    fk_receita smallint not null,
    constraint fk_receitas_passos foreign key(fk_receita)
		references receitas(id)
);

insert into receitas_passos(passo, fk_receita)
values('Coloque alguns cubos de gelo triturados ou inteiros no fundo do copo',1),
('Acrescente suco de manga',1),
('Coloque uma cápsula do café escolhido na máquina Nespresso e prepare-o (25 ml) no copo alto para receitas',1),
('Pressione o botão de espuma de leite fria',1),
('Coloque um wafer coberto com chocolate ao lado para decorar',1);




