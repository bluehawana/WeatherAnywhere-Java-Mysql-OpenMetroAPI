package se.dsve;

import se.dsve.controllers.CityManager;
import se.dsve.controllers.WeatherAPIClient;
import se.dsve.models.City;
import se.dsve.models.WeatherInfo;

import java.util.Scanner;

public class WeatherApp {
    private final WeatherAPIClient apiClient;
    private final Scanner scanner;
    private final CityManager cityManager; // Lägg till en referens till CityManager

    public WeatherApp() {
        this.apiClient = new WeatherAPIClient();
        this.scanner = new Scanner(System.in);
        this.cityManager = new CityManager(); // Instansiera CityManager
    }

    public void run() {
        System.out.println("Välkommen till Väderklienten! Skriv in namnet på en stad för att få aktuell väderinformation.");
        // TODO: Skriv din kod här
    }
}

