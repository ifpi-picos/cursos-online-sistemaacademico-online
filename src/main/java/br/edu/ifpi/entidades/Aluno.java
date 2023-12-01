package br.edu.ifpi.entidades;

public class Aluno {

    private int id_aluno;
    private String nome;
    private String email;

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
        
    }

    public Aluno(int id_aluno, String nome,String email) {
        this.id_aluno = id_aluno;
        this.nome = nome;
        this.email = email;
    }
    

    public Aluno() {
        
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
