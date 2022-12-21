package model;

import java.sql.SQLException;

public class Product {

    private Integer id;
    private String name;
    private String description;

    public Product(String name, String description) throws SQLException {
        this.name = name;
        this.description = description;
    }

    public Product(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Nome: " + this.name + ", descrição: " + this.description;
    }
}
