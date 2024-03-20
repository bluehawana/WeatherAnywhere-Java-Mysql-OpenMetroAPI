package se.dsve.controllers;
import org.junit.jupiter.api.Test;
import se.dsve.models.WeatherInfo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class WeatherAPIClientTest {

    @Test
    void testCreateConnection() throws IOException {
        URL testUrl = new URL("https://api.open-meteo.com/v1/forecast?latitude=0&longitude=0&hourly=temperature_2m,weather_code,wind_speed_10m&wind_speed_unit=ms&forecast_days=1");
        HttpURLConnection connection = (HttpURLConnection) testUrl.openConnection();
        WeatherAPIClient client = new WeatherAPIClient();
        WeatherInfo info = client.createConnection(connection);
        // perform assertions on info
    }
}