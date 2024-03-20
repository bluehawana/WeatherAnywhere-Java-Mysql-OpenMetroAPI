package se.dsve.models;

import org.json.JSONObject;

public class WeatherInfo {
    private double temperature; // Temperaturen i grader Celsius
    private double windSpeed; // Vindhastigheten i km/h
    private String tempratureUnit = "°C"; // Enhet för temperaturen
    private String windSpeedUnit="m";// Beskrivningen av vädret

    // Konstruktör som accepterar temperatur, vindhastighet och beskrivning
    public WeatherInfo(double temperature, double windSpeed, String description, String windSpeedUnit) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.tempratureUnit = tempratureUnit;
        this.windSpeedUnit = windSpeedUnit;
    }

    // Överlagrad konstruktör som accepterar temperatur och vindhastighet och sätter en standardbeskrivning

    public WeatherInfo(JSONObject jsonObject, double temperature, double windSpeed) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getTempratureUnit() {
        return tempratureUnit;
    }

    public String getWindSpeedUnit() {
        return windSpeedUnit;
    }
}
