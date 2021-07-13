-- Comentarios
-- A Linha abaixo cria um Banco de Dados
create database dbadopet;

-- A Linha Abaixo usa(seleciona) um Banco de Dados
use dbadopet;

-- o bloco de instruções abaixo cria uma tabela

create table tbclientes(
iduser int primary key auto_increment,
emailuser varchar(100) not null,
nomeuser varchar(70) not null,
senhauser varchar(15) not null,
sexouser varchar(30) not null,
RGuser int(20) not null
);
select * from tbclientes;

create table tbclientes1(
iduser1 int primary key not null auto_increment,
Cpfuser varchar(30) not null,
CEPuser int(25) not null,
Cidadeuser varchar(100) not null,
data_nasc_user varchar(20) not null
);
insert into tbclientes (emailuser, nomeuser, senhauser, sexouser, RGuser) 
values ("jonatasojeda@hotmail.com", "Jonatas Ojeda", "admin", "Masculino", "12345678");
insert into tbclientes1 (Cpfuser, CEPuser, Cidadeuser, data_nasc_user) 
values ("45642616811", 18077301, "Sorocaba", "29/09/2002");
select *from tbclientes;
select *from tbclientes1;


select *from tbclientes where iduser=2;

select *from tbclientes1 where iduser=2;

select *from tbclientes1 where Cpfuser=45642616811;


update tbclientes set emailuser="123",nomeuser="123",senhauser="123",sexouser="123",RGuser="123" where iduser=1;

update tbclientes1 set Cpfuser="1237",CEPuser="123",Cidadeuser="Sorocaba",data_nasc_user="123"where iduser1=1;

	
select *from tbclientes1 where iduser=1;

create table produtos(
idproduto int primary key not null auto_increment,
Fornecedor varchar(30) not null,
Marca varchar(40) not null,
Nome varchar(100) not null,
Preço varchar(20) not null,
EmailFornecedor varchar(20) not null,
TelefoneFornecedor varchar(20) not null
);

insert into produtos(Fornecedor, Marca,Nome,Preço,EmailFornecedor,TelefoneFornecedor)
 values ("1","1","1","1","1","1");
 
 select *from produtos;