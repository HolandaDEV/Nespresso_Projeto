use nespresso;

select * from categorias;

insert into capsulas(nome, complemento_nome, preco, qtde_unitaria, habilitado, fk_categoria)
values('Arpeggio', 'Intenso e Cremoso', 2.20, 1, 1, 2),
('Ristretto', 'Poderoso e Contrastante', 2.20, 1, 1, 2),
('Arpeggio Decaffeinato', 'Intenso e Cremoso', 2.20, 1, 1, 6);