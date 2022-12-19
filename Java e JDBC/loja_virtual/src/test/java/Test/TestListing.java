package Test;

import model.CreateConnection;

import java.sql.*;

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

        connection.close();
        statement.close();
        resultSet.close();
    }
}
