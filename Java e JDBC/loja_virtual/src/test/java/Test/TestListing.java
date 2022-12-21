package Test;

import model.CreateConnection;
import model.dao.CategoryDAO;
import model.dao.ProductDAO;

import java.sql.*;
import java.util.List;

public class TestListing {

    public static void main(String[] args) throws SQLException {

        CreateConnection createCon = new CreateConnection();
        Connection connection = createCon.createConnection();


        PreparedStatement statement = connection.prepareStatement("SELECT id, nome, descricao FROM PRODUTO");
        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String descricao = resultSet.getString("descricao");
            System.out.println("ID: " + id + ", Nome: " + nome + ", Descrição: " + descricao);
        }

        System.out.println("*************************************************************");

        ProductDAO product = new ProductDAO(connection);
        product.listProduct().stream().forEach(product1 -> System.out.println(product1));

        connection.close();
        statement.close();
        resultSet.close();
    }
}
