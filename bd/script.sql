CREATE DATABASE alunos;

CREATE TABLE `alunos`.`aluno` (
  `cpf` VARCHAR(11) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `matricula` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `data_nasc` VARCHAR(45) NOT NULL);


SELECT * from aluno;