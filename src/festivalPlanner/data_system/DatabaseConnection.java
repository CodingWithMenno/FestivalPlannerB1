package festivalPlanner.data_system;

import java.sql.*;

public class DatabaseConnection {

    public boolean establishConnection(String username, String password) throws SQLException {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://167.71.130.2:3306/festplanner_users", "grant", "7cQ4fpxVM")){

            System.out.println("Hoi");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username = ? and password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }


        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
        return false;

    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
