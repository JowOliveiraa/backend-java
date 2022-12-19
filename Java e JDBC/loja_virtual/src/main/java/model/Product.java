package model;

import java.sql.SQLException;

public class Product {

    private Integer id;
    private String nome;
    private String descricao;

    public Product(String nome, String descricao) throws SQLException {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Product(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Nome: " + this.nome + ", descrição: " + this.descricao;
    }
}
