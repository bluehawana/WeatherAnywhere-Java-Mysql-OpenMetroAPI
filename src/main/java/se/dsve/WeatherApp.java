package se.dsve;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONObject;
import se.dsve.controllers.CityManager;
import se.dsve.controllers.WeatherAPIClient;
import se.dsve.models.City;
import se.dsve.models.WeatherInfo;
import se.dsve.db.DatabaseHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Scanner;

public class WeatherApp {
    private final WeatherAPIClient apiClient;
    private final Scanner scanner;
    private final CityManager cityManager;
    public static Dotenv dotenv = Dotenv.load();
    private final DatabaseHandler databaseHandler;

    static {
        try {
            dotenv = Dotenv.load();
        } catch (Exception e) {
            System.err.println("Error loading environment variables: " + e.getMessage());
        }
    }

    public WeatherApp() throws SQLException {
        this.cityManager = new CityManager();
        this.apiClient = new WeatherAPIClient();
        this.scanner = new Scanner(System.in);
        this.databaseHandler = new DatabaseHandler();
    }

    public void run() throws SQLException {
        System.out.println("Välkommen till Väderklienten! Skriv in namnet på en stad för att få aktuell väderinformation.");
        System.out.println("Skriv 'avsluta' för att avsluta programmet.");

        while (true) {
            System.out.print("Ange en stad: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("avsluta")) {
                break;
            }

            try {
                City city = getCityFromDatabaseOrAddNew(input);

                if (city != null) {
                    WeatherInfo weatherInfo = apiClient.fetchWeather(city);
                    System.out.println("Vädret i " + city.getName() + ":");
                    System.out.println("Temperatur: " + weatherInfo.getTemperature() + "°C");
                    System.out.println("Vindhastighet: " + weatherInfo.getWindSpeed() + " km/h");
                    System.out.println("Väderbeskrivning: " + weatherInfo.getSwedishDescription());
                } else {
                    System.out.println("Kunde inte hitta väderinformation för den angivna staden.");
                }
            } catch (Exception e) {
                System.out.println("Ett fel inträffade: " + e.getMessage());
            }
        }
    }


    private City getCityFromDatabaseOrAddNew(String input) throws SQLException, IOException {
        City city = cityManager.getCity(input);

        if (city == null) {
            city = databaseHandler.getCityFromDatabase(input);
            if (city == null) {
                System.out.println("Staden finns inte i databasen. Vill du lägga till den? (ja/nej)");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("ja")) {
                    double[] latLong = fetchLatLong(input);
                    if (latLong != null) {
                        city = new City(input, latLong[0], latLong[1]);
                        cityManager.addCity(String.valueOf(city));
                        databaseHandler.saveCity(input, city.getLatitude(), city.getLongitude());
                    } else {
                        System.out.println("Kunde inte hitta latitud och longitud för staden.");
                    }
                }
            }
        }

        return city;
    }

    private double[] fetchLatLong(String cityName) throws IOException {
        String Your_API_KEY = dotenv.get("YOUR_API_KEY");
        if (Your_API_KEY == null) {
            System.err.println("API key not found in environment variables.");
            return null;
        }

        URL url = new URL("https://api.opencagedata.com/geocode/v1/json?q=" + URLEncoder.encode(cityName, "UTF-8") + "&key=" + Your_API_KEY);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            if (jsonResponse.getJSONArray("results").length() > 0) {
                JSONObject location = jsonResponse.getJSONArray("results").getJSONObject(0).getJSONObject("geometry");
                double latitude = location.getDouble("lat");
                double longitude = location.getDouble("lng");

                return new double[]{latitude, longitude};
            } else {
                System.out.println("API did not return any results for the city: " + cityName);
            }
        } else {
            System.out.println("API request failed with response code: " + responseCode);
        }

        return null;
    }
}
