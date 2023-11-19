package br.edu.ifpi.entidades;
import br.edu.ifpi.enums.StatusCurso;

public class Curso {
    private int id;
    private String nome;
    private StatusCurso status;
    private int cargahoraria;
    private int prof_id;

    public Curso(int id, String nome, StatusCurso status, int cargahoraria, int prof_id) {
        this.nome = nome;
        this.status = status;
        this.cargahoraria = cargahoraria;
        this.prof_id = prof_id;
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
    public int getProf_id(){
        return prof_id;
    }
}
