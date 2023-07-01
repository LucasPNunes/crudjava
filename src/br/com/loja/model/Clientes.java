package br.com.loja.model;

import java.util.Date;

public class Clientes {
    private int id;
    private String nome;
    private String email;
    private int idade;
    private Date dataCadastro;

    public Clientes(int id, String nome, String email, int idade, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
