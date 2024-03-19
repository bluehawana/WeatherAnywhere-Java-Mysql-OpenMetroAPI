package se.dsve.controllers;

import org.json.JSONObject;
import se.dsve.models.City;
import se.dsve.models.WeatherInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPIClient {

    private static final String API_BASE_URL = "https://api.open-meteo.com/v1/forecast";

    public WeatherInfo fetchWeather(City city) {
        // TODO: Skriv din kod här
        return null;
    }

    protected HttpURLConnection createConnection(URL url) throws Exception {
        // TODO: Skriv din kod här
        return null;
    }

    WeatherInfo parseWeatherData(String jsonResponse) {
        // TODO: Skriv din kod här
        return null;
    }
}
