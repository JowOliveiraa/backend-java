package model;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class CreateConnection {

    public DataSource dataSource;

    public CreateConnection() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
        cpds.setUser("root");
        cpds.setPassword("0810");
        cpds.setMaxPoolSize(15);

        this.dataSource = cpds;
    }

    public Connection createConnection() throws SQLException {
        return this.dataSource.getConnection();

    }
}
