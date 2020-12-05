use senac;

create table cliente(
id int auto_increment,
nome varchar(250) not null,
cnh varchar(11) unique not null,
cpf varchar(11) unique not null,
idade int not null,
celular int not null,
primary key(id)
);


create table funcionario(
id int auto_increment,
nome varchar(250) not null,
cargo int not null,
idLoja int,
primary key(id),
foreign key (idLoja) references loja(id)
);

create table usuario(
id int auto_increment,
email varchar(200) not null,
senha varchar(10) not null,
idFuncionario int,
primary key(id),
foreign key (idFuncionario) references funcionario(id)
);

create table carro(
id int auto_increment,
marca varchar(100) not null,
modelo varchar(100) not null,
qntPortas int not null,
placa varchar(8) unique not null,
preco decimal(10,2) not null,
idLoja int,
primary key(id),
foreign key (idLoja) references loja(id)
);

create table aluguel(
id int auto_increment,
dataLocacao date,
dataDevolucao date,
juros double,
localRetirada varchar(100) not null,
localDevolucao varchar(100) not null,
qntDiaAluguel int,
idCliente int,
idCarro int,
primary key(id),
foreign key (idCliente) references cliente(id),
foreign key (idCarro) references carro(id)
);


create table loja(
id int auto_increment,
loja varchar(100) not null,
primary key(id)
);


/*Lista de Cargos:
1 - Gerente regional
2 - Gerente global
3 - Serviços
4 - Marketing
5 - TI
*/

/*Lista de Lojas:
1 - São Paulo - Matriz
2 - Campo Grande - Filial
3 - Joinville - Filial
4 - Brasilia - Filial
*/

insert into loja (loja) values
("São Paulo"),
("Campo Grande"),
("Joinville"),
("Brasilia");

insert into carro(marca, modelo, qntPortas, placa, preco, idLoja) values 
("Volkswagen", "Up", 2, "DGF-8921", 125.90, 1),
("BMW", "X1", 4, "DFZ-8189", 450.99, 2),
("Renault", "Logan", 4, "AAA-5678", 135.95, 3),
("Chevrolet", "Onix", 2, "BAA-8223", 130.99, 4),
("Hyundai", "HB20", 4, "CCD-2321", 115.00, 1);

/*Cadastro de Alugueis*/
insert into aluguel (dataLocacao, dataDevolucao, localRetirada, localDevolucao, qntDiaAluguel, idCliente, idCarro) values
("2020-11-10", "2020-11-12", "Congonhas", "Congonhas", 2, 2, 3),
("2020-10-23", "2020-11-01", "Congonhas", "Congonhas", 9, 1, 4),
("2020-11-26", "2020-11-27", "Congonhas", "Congonhas", 1, 5, 2),
("2020-11-27", "2020-11-27", "Congonhas", "Guarulhos", 1, 4, 1),
("2020-11-27", "2020-11-27", "Congonhas", "Guarulhos", 1, 1, 1),
("2020-11-27", "2020-11-27", "Congonhas", "Guarulhos", 1, 3, 1);

insert into cliente (nome, cnh, cpf, idade, celular) values
("Ana Claudia Silva", "6272883937", "82727839", 23, "98765432"),
("Pamela Santos", "930892821", "90903281", 25, "2132132112"),
("Gustavo Ferreira", "092138092", "92030921", 46, "123122131"),
("Tatiane Araujo", "09218309128", "92132712", 38, "902713091"),
("Marcos Fernandes", "35425324", "34252335", 25, "0982103981");

select * from carro;
select * from aluguel;
select * from cliente;
select * from loja;


/*Relatório de alugueis*/
select aluguel.id, carro.placa, carro.preco, carro.marca, carro.modelo, aluguel.qntDiaAluguel, cliente.nome, carro.idLoja, loja.loja,
carro.preco*aluguel.qntDiaAluguel as 'diariaTotal'
from (((aluguel
inner join carro on aluguel.idCarro = carro.id)
inner join loja on loja.id = carro.idLoja)
inner join cliente on aluguel.idCliente = cliente.id)
group by aluguel.id;

select carro.id, carro.idLoja, loja.loja
from (carro
inner join loja on carro.idLoja = loja.id)
group by carro.id;

/*Itens mais vendidos*/
select modelo as "Carro",
count(*) as "Quantidade de Aluguel"
from carro
group by modelo
order by count(*) desc;


/*Relatório de cliente*/
select cliente.id, cliente.nome;


select sum(preco) as TotalAluguel from aluguel;
