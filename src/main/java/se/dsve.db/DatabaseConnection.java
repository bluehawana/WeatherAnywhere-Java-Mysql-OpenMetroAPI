package se.dsve.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static se.dsve.WeatherApp.dotenv;

public class DatabaseConnection {
    private static final String DB_SERVER = dotenv.get("DB_SERVER");
    private static final String DB_PORT = dotenv.get("DB_PORT");
    private static final String DB_DATABASE = dotenv.get("DB_DATABASE");
    private static final String DB_USER = dotenv.get("DB_USER");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    private static final String DB_URL = "jdbc:mysql://" + DB_SERVER + ":" + DB_PORT + "/" + DB_DATABASE + "?useSSL=false&allowPublicKeyRetrieval=true";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to create a connection to the database");
            if (e.getCause() instanceof com.mysql.cj.exceptions.CJCommunicationsException) {
                System.out.println("Unable to communicate with the database. Please check your network connection and database server status.");
                e.printStackTrace(); // Print the full stack trace for further debugging
            } else {
                e.printStackTrace(); // Print the full stack trace for further debugging
            }
            return null;
        }
    }
}