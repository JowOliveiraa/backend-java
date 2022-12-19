package Test;

import model.CreateConnection;
import model.Product;
import model.dao.ProductDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class TestInsertionWithProduct {

    public static void main(String[] args) throws SQLException {

        //Product product = new Product("Tablet", "Tablet da LG");

        try(Connection connection = new CreateConnection().createConnection()) {
            //new ProductDAO(connection).saveProduct(product);
            new ProductDAO(connection).listProduct();
        }

    }
}
