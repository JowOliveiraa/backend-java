package model.dao;

import model.Category;
import model.CreateConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection connection;

    public ProductDAO(Connection connection){
        this.connection = connection;
    }

    public void saveProduct(Product product) throws SQLException {
        try(Connection connection = new CreateConnection().createConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO PRODUTO(nome, descricao) values(?, ?)");

            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.execute();
        }
    }

    public List<Product> listProduct() throws SQLException {
            List<Product> products = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM PRODUTO;")) {
                statement.execute();

                try(ResultSet resultSet = statement.getResultSet()) {
                    while (resultSet.next()) {
                        Product product = new Product(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3));
                        products.add(product);
                    }
                }
        }
        return products;
    }

    public List<Product> search(Category category) throws SQLException {
        List<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM PRODUTO WHERE catogira_id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, category.getId());
            statement.execute();

            try(ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    Product product = new Product(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3));
                    products.add(product);
                }
            }
        }
        return products;
    }
}
