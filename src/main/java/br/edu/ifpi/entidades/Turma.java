package br.edu.ifpi.entidades;

public class Turma {
    private int id_turma;
    private int id_curso;
    private int id_aluno;
    private double nota;

    
    public Turma(int id_turma, int id_curso, double nota) {
        this.id_turma = id_turma;
        this.id_curso = id_curso;
        this.nota = nota;
    }

    public Turma(int id_turma,int id_curso, int id_aluno, double nota) {
        this.id_turma = id_turma;
        this.id_curso = id_curso;
        this.id_aluno = id_aluno;
        this.nota = nota;
    }


    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    } 
}
