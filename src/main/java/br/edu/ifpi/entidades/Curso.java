package br.edu.ifpi.entidades;
import java.io.ObjectInputFilter.Status;

import br.edu.ifpi.enums.StatusCurso;

public class Curso {
    private int id;
    private String nomeC;
    private int carga_horaria;
    private int id_professor;
    private StatusCurso status;
    
    public Curso(int id, String nomeC,int carga_horaria, int id_professor, StatusCurso status) {
        this.nomeC = nomeC;
        this.carga_horaria = carga_horaria;
        this.id_professor = id_professor;
        this.status = status;
    }
    
    public Curso() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeC() {
        return nomeC;
    }
    public void setNome(String nome) {
        this.nomeC = nome;
    }

    public StatusCurso getStatus() {
        return status;
    }
    public void setStatus(StatusCurso status) {
        this.status = status;
    }

    public int getCargahoraria() {
        return carga_horaria;
    }
    public void setCargahoraria(int cargahoraria) {
        this.carga_horaria = cargahoraria;
    }
    public int getProf_id(){
        return id_professor;
    }
    public void setProf_id(int id_professor) {
        this.id_professor = id_professor;
    }

    public void setStatus(Status valueOf) {
    }
}
