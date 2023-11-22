package br.edu.ifpi.entidades;

public class Turma {
    private int id_turma;
    private int id_professor;
    private int id;
    private double nota;

    
    public Turma(int id_professor, int id, double nota) {
        this.id_professor = id_professor;
        this.id = id;
        this.nota = nota;
    }

    public Turma(int id_turma,int id_professor, int id, double nota) {
        this.id_turma = id_turma;
        this.id_professor = id_professor;
        this.id = id;
        this.nota = nota;
    }


    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    } 
}
