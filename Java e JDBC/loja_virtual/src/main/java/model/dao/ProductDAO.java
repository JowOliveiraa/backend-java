package model.dao;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.sun.source.tree.TryTree;
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

            statement.setString(1, product.getNome());
            statement.setString(2, product.getDescricao());
            statement.execute();
        }
    }

    public void listProduct() throws SQLException {

        try(PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM PRODUTO;")) {
                statement.execute();

                try(ResultSet resultSet = statement.getResultSet()) {
                    while (resultSet.next()) {
                        Product product = new Product(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3));
                        System.out.println(product);
                    }
                }
        }
    }
}
