DROP DATABASE sistemaacademico;
CREATE DATABASE sistemaacademico;
\c sistemaacademico;

CREATE TABLE professor(
    id serial NOT NULL,
    nome varchar (250) NOT NULL,
    email character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE aluno(
    id serial NOT NULL,
    nome varchar (250) NOT NULL,
    email character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE curso(
    id serial NOT NULL,
    status varchar (250) NOT NULL,
    nome varchar (250) NOT NULL,
    carga_horaria INTEGER NOT NULL,
    id_professor INTEGER NOT NULL,
    PRIMARY KEY (id), 
    FOREIGN KEY (id_professor) REFERENCES professor(id)
    
);

CREATE TABLE turma(
    id_curso int,
    id_aluno int,
    nota float(25),
    situacao VARCHAR(255),
    FOREIGN KEY (id_curso) REFERENCES curso(id),
    FOREIGN key (id_aluno) REFERENCES aluno(id)
);