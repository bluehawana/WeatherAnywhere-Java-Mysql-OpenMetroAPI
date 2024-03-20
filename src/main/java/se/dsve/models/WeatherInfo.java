package se.dsve.models;

import org.json.JSONObject;

import se.dsve.models.WeatherDescription;

public class WeatherInfo {
    private final double temperature; // Temperaturen i grader Celsius
    private final double windSpeed; // Vindhastigheten i km/h
    private final String description; // Beskrivningen av vädret

    // Konstruktör som accepterar temperatur, vindhastighet och beskrivning
    public WeatherInfo(double temperature, double windSpeed, String description) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.description = description;
    }

    // Överlagrad konstruktör som accepterar temperatur och vindhastighet och sätter en standardbeskrivning
    public WeatherInfo(double temperature, double windSpeed) {
        this(temperature, windSpeed, "Ingen beskrivning tillgänglig");
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getDescription() {
        return description;
    }
}

