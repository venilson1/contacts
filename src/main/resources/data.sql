/*

  CREATE TABLE tb_contact (
	id  bigserial not null, 
	name varchar(255), 
	last_name varchar(255), 
	cpf varchar(255),
	email varchar(255), 
	phone varchar(255), 
	primary key (id));

*/

INSERT INTO tb_contact (name, last_name, cpf, email, phone) VALUES ('Bob', 'Brown', '235.588.965-56', 'bob@gmail.com', '011959058945');
INSERT INTO tb_contact (name, last_name, cpf, email, phone) VALUES ('Mary', 'Crawler', '123.698.695-79', 'mary@gmail.com', '011969582514');
INSERT INTO tb_contact (name, last_name, cpf, email, phone) VALUES ('Charlie', 'Jeen', '456.741.125-09', 'charlie@gmail.com', '011978561265');
INSERT INTO tb_contact (name, last_name, cpf, email, phone) VALUES ('Rock', 'Balboa', '789.398.987-00', 'rock@gmail.com', '011974123698');

