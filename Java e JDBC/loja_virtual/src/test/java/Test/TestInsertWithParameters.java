package Test;

import model.CreateConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestInsertWithParameters {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        CreateConnection createCon = new CreateConnection();
        Connection connection = createCon.createConnection();



        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO PRODUTO(nome, descricao) values(?, ?)");

        insertProduct(statement);

        connection.close();
        statement.close();

    }

    public static void addProduct(String nome, String descricao, PreparedStatement statement) throws SQLException {

        statement.setString(1, nome);
        statement.setString(2, descricao);
        statement.execute();
    }

    public static void insertProduct( PreparedStatement statement) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String nome = scanner.nextLine();
        String descricao = scanner.nextLine();

        addProduct(nome, descricao, statement);

    }
}
