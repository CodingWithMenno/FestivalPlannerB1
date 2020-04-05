package festivalPlanner.data_system;

import planner_viewer.planner_modules.StageModule;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class makes the connection between the database and the java program
 */

public class DatabaseConnection {

    private String databaseAddress = "jdbc:mysql://167.71.130.2:3306/festplanner_users";
    private String databaseUsername = "ApplicationAccess";
    private String databasePassword = "4ed6a481f14b4b9c98b05959e3d29782";

    private Connection databaseConnection;

    private Boolean connectionStatus;

    private String activeUser;

    /**
     * This Class ensures a database connection to a MySQL database.
     * This was an extra feature, and is only used at the login screen.
     * @throws SQLException
     */
    public DatabaseConnection() throws SQLException {

        try {
            this.databaseConnection = DriverManager.getConnection(this.databaseAddress, this.databaseUsername, this.databasePassword);
            this.connectionStatus = true;
        } catch (SQLException e){
            this.connectionStatus = false;
            printSQLException(e);
        }

    }

    public ArrayList<Stage> updateStageTable() throws SQLException {

        ArrayList<Stage> stages = new ArrayList<>();

        PreparedStatement fetchStageTable = this.databaseConnection.prepareStatement("SELECT * FROM stages WHERE userRelationship = ?");
        fetchStageTable.setString(1, this.activeUser);

        ResultSet databaseReply = fetchStageTable.executeQuery();

        while( databaseReply.next() ) {

            stages.add(new Stage(databaseReply.getString(1),
                    databaseReply.getInt(2),
                    databaseReply.getInt(3),
                    databaseReply.getBoolean(4),
                    databaseReply.getString(5),
                    databaseReply.getInt(6)));

        }

        return stages;
    }

    public ArrayList<Event> updateEventTable() throws SQLException {

        ArrayList<Event> events = new ArrayList<>();

        PreparedStatement fetchStageTable = this.databaseConnection.prepareStatement("SELECT * FROM events WHERE userRelationship = ?");
        fetchStageTable.setString(1, this.activeUser);

        ResultSet databaseReply = fetchStageTable.executeQuery();

        while( databaseReply.next() ) {

//            events.add(new Event(databaseReply.getString(1),
//                    databaseReply.getString(2),
//                    databaseReply.getDouble(3),
//                    databaseReply.getDouble(4),
//                    databaseReply.getString(5),
//                    databaseReply.getString(6)));

        }

        return events;
    }

    public String fetchUserOrganization() throws SQLException {

        PreparedStatement userOrganization = this.databaseConnection.prepareStatement("SELECT Organization FROM user WHERE username = ?");
        userOrganization.setString(1, this.activeUser);

        ResultSet databaseReply = userOrganization.executeQuery();
        databaseReply.next();

        return databaseReply.getString("Organization");
    }

    public boolean validateUser(String username, String password) throws SQLException {

        this.activeUser = username;

        PreparedStatement userValidationQuery = this.databaseConnection.prepareStatement("SELECT * FROM user WHERE username = ? and password = ?");
        userValidationQuery.setString(1, username);
        userValidationQuery.setString(2, password);

        ResultSet databaseValidationReply = userValidationQuery.executeQuery();

        return databaseValidationReply.next();

    }

    public boolean connectionStatus(){
        return this.connectionStatus;
    }


    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    t = t.getCause();
                }
            }
        }
    }
}
