package se.dsve;

// https://open-meteo.com/
// https://open-meteo.com/doc

import java.sql.SQLException;

public class git Main {
    public static void main(String[] args) throws SQLException {
        WeatherApp weatherApp = new WeatherApp();
        weatherApp.run();
    }
}
