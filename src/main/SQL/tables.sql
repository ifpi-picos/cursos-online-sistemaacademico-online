CREATE TABLE aluno(
    ID serial NOT NULL,
    NOME varchar (250) NOT NULL,
    EMAIL character varying(255) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE curso(
    ID serial NOT NULL,
    NOME varchar (250) NOT NULL,
    -- STATUS ENUM 
    CARGAHORARIA INTEGER NOT NULL,
    PROF_ID INTEGER NOT NULL,
    PRIMARY KEY (ID), 
    FOREIGN KEY (PROF_ID) REFERENCES professor(id)
    
);

CREATE TABLE turma(
    id_curso int,
    id_aluno int,
    notas float(25),
    situacao status,
    FOREIGN KEY (id_curso) REFERENCES curso(id),
    FOREIGN key (id_aluno) REFERENCES aluno(id)
);