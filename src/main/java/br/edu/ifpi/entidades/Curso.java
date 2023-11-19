package br.edu.ifpi.entidades;
import br.edu.ifpi.enums.StatusCurso;

public class Curso {
    private int id;
    private String nome;
    private StatusCurso status;
    private int cargahoraria;

    public Curso(int id, String nome, StatusCurso status, int cargahoraria) {
        
        this.nome = nome;
        this.status = status;
        this.cargahoraria = cargahoraria;
        
        
    }
    
    public Curso() {
        
    }
    public int getId() {
        return id;
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
