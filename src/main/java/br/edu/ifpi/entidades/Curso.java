package br.edu.ifpi.entidades;
import java.io.ObjectInputFilter.Status;

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
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusCurso getStatus() {
        return status;
    }
    public void setStatus(StatusCurso status) {
        this.status = status;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }
    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }
    public int getProf_id(){
        return prof_id;
    }
    public void setProf_id(int prof_id) {
        this.prof_id = prof_id;
    }

    public void setStatus(Status valueOf) {
    }
}
