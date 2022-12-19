package Test;

import model.CreateConnection;

import java.sql.SQLException;

public class TestPoolConnections {

    public static void main(String[] args) throws SQLException {

        CreateConnection createCon = new CreateConnection();

        for (int i= 0; i < 20; i++) {
            createCon.createConnection();
            System.out.println("Conexão de número: " + i);
        }
    }
}
