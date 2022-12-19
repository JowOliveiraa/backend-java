package Test;

import model.CreateConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

    public static void main(String[] args) throws SQLException {
        CreateConnection createCon = new CreateConnection();
        Connection connection = createCon.createConnection();
        Statement statement = connection.createStatement();

        statement.execute("INSERT INTO PRODUTO(nome, descricao) values('Mouse', 'Mouse sem fio')");
        connection.close();
        statement.close();

    }
}
