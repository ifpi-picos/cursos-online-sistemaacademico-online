package br.edu.ifpi.entidades;

import br.edu.ifpi.enums.StatusCurso;

public class Curso {

    private String nome;
    private StatusCurso status;
    private int cargahoraria;

    public Curso(String nome, StatusCurso status,int cargahoraria) {

        this.nome = nome;
        this.status = status;
        this.cargahoraria = cargahoraria;
        

    }

    public Curso() {

    }

    public String getNome() {
        return nome;
    }

    public StatusCurso getStatus() {
        return status;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }
}
