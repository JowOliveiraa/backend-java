package model.dao;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Category> listCategory() throws SQLException {
        List<Category> categories = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement("SELECT id, nome FROM CATEGORIA;")){
            statement.execute();

            try(ResultSet resultSet = statement.getResultSet()){
                while (resultSet.next()){
                    Category category = new Category(
                            resultSet.getInt("id"),
                            resultSet.getString("nome")
                    );
                    categories.add(category);
                }
            }
        }
        return categories;
    }
}
