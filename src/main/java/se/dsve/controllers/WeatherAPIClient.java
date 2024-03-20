package se.dsve.controllers;

import org.json.JSONObject;
import se.dsve.models.City;
import se.dsve.models.WeatherDescription;
import se.dsve.models.WeatherInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPIClient {
    private static final String API_BASE_URL = "https://api.open-meteo.com/v1/forecast";

    public WeatherAPIClient() {
    }

    public WeatherInfo fetchWeather(City city) throws IOException {
        if (city == null) {
            throw new IllegalArgumentException("City cannot be null.");
        }

        double latitude = city.getLatitude();
        double longitude = city.getLongitude();
        URL apiUrl = new URL(API_BASE_URL + "?latitude=" + latitude + "&longitude=" + longitude + "&hourly=temperature_2m,weather_code,wind_speed_10m&wind_speed_unit=ms&forecast_days=1");
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        try {
            return createConnection(connection);
        } finally {
            connection.disconnect();
        }
    }

    private WeatherInfo createConnection(HttpURLConnection connection) throws IOException {
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed to fetch weather data. Response code: " + responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        return parseWeatherData(jsonResponse);
    }

    WeatherInfo parseWeatherData(JSONObject jsonResponse) {
        JSONObject hourlyData = jsonResponse.getJSONObject("hourly");
        double temperature = hourlyData.getJSONArray("temperature_2m").getDouble(0);
        double windSpeed = hourlyData.getJSONArray("wind_speed_10m").getDouble(0);
        int weatherCode = hourlyData.getJSONArray("weather_code").getInt(0);

        String weatherDescription = WeatherDescription.getWeatherDescription(weatherCode);

        return new WeatherInfo(temperature, windSpeed, weatherDescription);
    }
}