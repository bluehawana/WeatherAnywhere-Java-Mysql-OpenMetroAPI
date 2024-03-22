

package se.dsve.db;

import org.h2.engine.Database;
import se.dsve.models.City;
import se.dsve.controllers.CityManager;

import java.io.IOException;
import java.sql.*;

import static se.dsve.WeatherApp.dotenv;

public class DatabaseHandler {
    private static final String DB_DATABASE = dotenv.get("DB_DATABASE");

    private Connection connection;
    private Database database;
    private static final String DB_SERVER = dotenv.get("DB_SERVER");
    private static final String DB_PORT = dotenv.get("DB_PORT");
    private static final String DB_USER = dotenv.get("DB_USER");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    private static final String DB_URL = "jdbc:mysql://" + DB_SERVER + ":" + DB_PORT + "/";
    private static final String CONNECTION_URL = DB_URL + "?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String CREATE_DATABASE_SQL = "CREATE DATABASE IF NOT EXISTS " + DB_DATABASE;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS weather ( cityName VARCHAR(50), latitude DOUBLE, longitude DOUBLE)";

    public DatabaseHandler() throws SQLException {
        connection = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD);
        initializeDatabase();
    }

    private void initializeDatabase() throws SQLException {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            // Create the database if it doesn't exist
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS weather");
            // Switch to the 'weather' database
            statement.execute("USE weather");
            // Create the 'weather' table if it doesn't exist
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS weather (cityName VARCHAR(50), latitude DOUBLE, longitude DOUBLE)");
            System.out.println("Database and table checked/created successfully");
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void printSQLException(SQLException ex) {
        if (ex != null) {
            System.out.println("Error Message: " + ex.getMessage());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("SQL State: " + ex.getSQLState());
            Throwable t = ex.getCause();
            while (t != null) {
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }
    }

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD);
            try (Statement statement = connection.createStatement()) {
                statement.execute("USE " + DB_DATABASE);
            }
            return connection;
        } catch (SQLException e) {
            printSQLException(e);
            return null;
        }
    }

    public boolean cityExists(String cityName) {
        String checkCitySql = "SELECT COUNT(*) FROM weather WHERE cityName = ?";
        try (Connection conn = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD)) {
            conn.setCatalog("weather"); // Select the 'weather' database
            try (PreparedStatement checkCityStmt = conn.prepareStatement(checkCitySql)) {
                checkCityStmt.setString(1, cityName);
                ResultSet rs = checkCityStmt.executeQuery();
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public City getCityFromDatabase(String cityName) throws SQLException, IOException {
        String input=cityName;
        City city = CityManager.getCity(input);

        String getCitySql = "SELECT * FROM weather WHERE cityName = ?";
        try (Connection conn = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD)) {
            conn.setCatalog("weather");
            try (PreparedStatement getCityStmt = conn.prepareStatement(getCitySql)) {
                getCityStmt.setString(1, cityName);
                ResultSet rs = getCityStmt.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("cityName");
                    double latitude = rs.getDouble("latitude");
                    double longitude = rs.getDouble("longitude");
                    System.out.println("Retrieved city: " + name);
                    return new City(name, latitude, longitude);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Could not retrieve city: " + cityName);
        return null;
    }
    public void saveCity(String cityName, double latitude, double longitude) {
        String insertCitySql = "INSERT INTO weather (cityName, latitude, longitude) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE latitude=?, longitude=?";
        try (Connection conn = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD)) {
            // Switch to the 'weather' database
            conn.setCatalog("weather");
            try (PreparedStatement insertCityStmt = conn.prepareStatement(insertCitySql)) {
                insertCityStmt.setString(1, cityName);
                insertCityStmt.setDouble(2, latitude);
                insertCityStmt.setDouble(3, longitude);
                insertCityStmt.setDouble(4, latitude);
                insertCityStmt.setDouble(5, longitude);
                insertCityStmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
