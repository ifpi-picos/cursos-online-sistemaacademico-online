package br.edu.ifpi.entidades;

public class Aluno {

    private int id;
    private String nome;
    private String email;
    private Curso curso;

    public Aluno(String nome, String email, Curso curso) {
        this.nome = nome;
        this.email = email;
        this.curso = curso;
    }

    public Aluno(int id, String nome,String email, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
    }

    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
