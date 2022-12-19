package Test;

import model.CreateConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConection {

    public static void main(String[] args) throws SQLException {

        CreateConnection createCon = new CreateConnection();
        Connection connection = createCon.createConnection();

        System.out.println("Fechando conexão");
        connection.close();
    }
}
