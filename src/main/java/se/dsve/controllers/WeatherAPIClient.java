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
    private final CityManager cityManager   ;


    public WeatherAPIClient(CityManager cityManager) {
        this.cityManager = cityManager;
    }
    public WeatherInfo fetchWeather(City city) throws Exception {
        if (city == null) {
               throw new IllegalArgumentException("Unknown city: " + city.getName());
        }
        double latitude = city.getLatitude();
        double longitude = city.getLongitude();
        // Skapa URL för att hämta väderdata för den givna staden
        URL apiUrl = new URL(API_BASE_URL + "?latitude=" + latitude + "&longitude=" + longitude+"&hourly=temperature_2m,weather_code,wind_speed_10m&wind_speed_unit=ms&forecast_days=1");
        // Skapa en HTTP-anslutning med hjälp av createConnection-metoden
        HttpURLConnection connection = createConnection(apiUrl);

        try {
            // Hämta svarskoden för att kontrollera om förfrågan lyckades
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("Failed to fetch weather data. Response code: " + responseCode + " for URL: " + apiUrl);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Convert the response to a JSONObject
            JSONObject jsonResponse = new JSONObject(response.toString());

            return parseWeatherData(jsonResponse);
        } finally {
            connection.disconnect();
        }
    }

    protected HttpURLConnection createConnection(URL url) throws Exception {
        // TODO: Skriv din kod här
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        connection.setConnectTimeout(5000);

        connection.setReadTimeout(5000);

        return connection;
    }

    WeatherInfo parseWeatherData(JSONObject jsonResponse) {
        JSONObject hourlyData = jsonResponse.getJSONObject("hourly");
        JSONObject hourlyUnits = jsonResponse.getJSONObject("hourly_units");

        double temperature = hourlyData.getJSONArray("temperature_2m").getDouble(0);
        double windSpeed = hourlyData.getJSONArray("wind_speed_10m").getDouble(0);
        int weatherCode = hourlyData.getJSONArray("weather_code").getInt(0);

        String temperatureUnit = hourlyUnits.getString("temperature_2m");
        String windSpeedUnit = hourlyUnits.getString("wind_speed_10m");
        String weatherDescription = WeatherDescription.getWeatherDescription(weatherCode);

        return new WeatherInfo(temperature, windSpeed, temperatureUnit, windSpeedUnit, weatherDescription);
    }
}
