package se.dsve.models;

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
        return 0.0;
    }

    public double getWindSpeed() {
        return 0.0;
    }

    public String getDescription() {
        return "Ingen beskrivning tillgänglig";
    }
}


