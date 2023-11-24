package br.edu.ifpi.entidades;

public class Turma {
    // private int id_turma;
    private int id_curso;
    private int id_aluno;
    private double nota;
    
    
    public Turma() {
    }
    
    public Turma(int id_curso, int id_aluno, double nota) {
        // this.id_turma = id_turma;
        this.id_curso = id_curso;
        this.id_aluno = id_aluno;
        this.nota = nota;
    }
    // public int getId_turma() {
    //     return id_turma;
    // }
    
    // public void setId_turma(int id_turma) {
    //     this.id_turma = id_turma;
    // }
    public int getId_curso() {
        return id_curso;
    }
    
    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }
    public double getNota() {
        return nota;
    }
    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }
    public void setNota(double nota) {
        this.nota = nota;
    } 
}
