package br.edu.ifpi.entidades;

public class Professor {
    private String nome;
    private int id;
    private String email;

    public Professor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Professor(String nome, int id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }



}
