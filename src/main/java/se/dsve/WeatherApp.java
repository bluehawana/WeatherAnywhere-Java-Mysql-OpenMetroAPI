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
        this.cityManager = new CityManager(); // Instantiate CityManager
        this.apiClient = new WeatherAPIClient(cityManager)  ; // Instantiate WeatherAPIClient
        this.scanner = new Scanner(System.in); // Instansiera CityManager
    }

    public void run() {
        System.out.println("Välkommen till Väderklienten! Skriv in namnet på en stad för att få aktuell väderinformation.");
        // TODO: Skriv din kod här
        System.out.println("Skriv 'avsluta' för att avsluta programmet.");

        while (true) {
            System.out.print("Ange en stad: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("avsluta")) {
                break;
            }
            try {
                City city = cityManager.getCity(input); // Hämta staden från CityManager
                if (city == null) {
                    System.out.println("Okänd stad. Försök igen.");
                    continue;
                }
                WeatherInfo weatherInfo = apiClient.fetchWeather(city);
                System.out.println("Vädret i " + city.getName() + ":");
                System.out.println("Temperatur: " + weatherInfo.getTemperature() + "°C");
                System.out.println("Vindhastighet: " + weatherInfo.getWindSpeed() + " km/h");
            } catch (Exception e) {
                System.out.println("Ett fel inträffade: " + e.getMessage());
            }
        }
    }
}
