package stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    public static boolean authenticateUser(Connection connection, String username, String password) throws SQLException {
        String query = "SELECT * FROM USER WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public static boolean addUser(Connection connection, String username, String password) throws SQLException {
        String query = "INSERT INTO USER (username, password) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    }


}
