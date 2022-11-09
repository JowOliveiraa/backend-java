package br.com.alura.io.test;

import java.io.Serial;

public class Cliente implements java.io.Serializable  {

    @Serial
    private static final long serialVersionUID = 1L;
    private String nome;
    private String cpf;
    private String profissao;

    public Cliente ( String nome, String cpf, String profissao ) {

        this.nome = nome;
        this.cpf = cpf;
        this.profissao = profissao;

    }

    public String getNome() {
     return nome;
    }

    public void setNome(String nome) {
     this.nome = nome;
    }

    public String getCpf() {
     return cpf;
    }

    public void setCpf(String cpf) {
     this.cpf = cpf;
    }

    public String getProfissao() {
     return profissao;
    }

    public void setProfissao(String profissao) {
     this.profissao = profissao;
    }

    @Override
    public String toString() {
        return this.nome + ", " + this.cpf +", " + this.profissao;
    }
}