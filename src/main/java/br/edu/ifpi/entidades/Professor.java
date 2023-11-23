package br.edu.ifpi.entidades;

public class Professor {
    private String nomeP;
    private int id;
    private String email;

    public Professor(String nomeP, String email) {
        this.nomeP = nomeP;
        this.email = email;
    }

    public Professor(int id,String nome, String email) {
        this.nomeP = nomeP;
        this.id = id;
        this.email = email;
    }

    public String getNomeP() {
        return nomeP;
    }
    public int getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }



}
