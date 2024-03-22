package se.dsve.controllers;

import se.dsve.models.City;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the cities and their corresponding geographical data.
 * Hanterar städer och deras geografiska data.
 */
public class CityManager {
    private static final Map<String, City> cities = new HashMap<>();
    private City addCity;

    /**
     * Initializes the city manager with predefined cities.
     */
    public CityManager() {
        addPredefinedCities();
    }

    private void addPredefinedCities() {
        // TODO: Skriv din kod här
        // TODO: Addera städer till cities (Göteborg, Stockholm, Malmö, Kiruna, Växjö)
        // TODO: Skapa alias till städer för skojs skull (Götet, Möllan, Kiran, Fjollträsk, Växjöv)
        // https://cercurius.se/ordlistor/smeknamn-svenska-stader.php
        cities.put("Göteborg", new City("Göteborg", 57.7072, 11.9668));
        cities.put("Stockholm", new City("Stockholm", 59.3293, 18.0686));
        cities.put("Malmö", new City("Malmö", 55.6044, 13.0038));
        cities.put("Möllan", new City("Malmö", 55.6044, 13.0038));
        cities.put("Kiruna", new City("Kiruna", 67.8557, 20.2253));
        cities.put("Mölndal", new City("Mölndal", 57.6522, 12.0024));
        cities.put("Växjö", new City("Växjö", 56.8777, 14.8094));
        cities.put("Kalmar", new City("Kalmar", 56.6616, 16.3616));
        cities.put("Lund", new City("Lund", 55.7047, 13.1910));
        cities.put("Uppsala", new City("Uppsala", 59.8586, 17.6389));
        cities.put("Helsingborg", new City("Helsingborg", 56.0465, 12.6944));
        cities.put("Norrköping", new City("Norrköping", 58.5877, 16.1924));
        cities.put("Jönköping", new City("Jönköping", 57.7826, 14.1616));
        cities.put("Nyköping", new City("Nyköping", 58.7517, 17.0077));
        cities.put("Örebro", new City("Örebro", 59.2753, 15.2134));
        cities.put("Västerås", new City("Västerås", 59.6098, 16.5448));
        cities.put("Linköping", new City("Linköping", 58.4108, 15.6213));
        cities.put("Halmstad", new City("Halmstad", 56.6745, 12.8568));
        cities.put("Eskilstuna", new City("Eskilstuna", 59.3666, 16.5079));
        cities.put("Södertälje", new City("Södertälje", 59.1952, 17.6256));
        cities.put("Täby", new City("Täby", 59.437, 18.070));
        cities.put("Karlstad", new City("Karlstad", 59.3793, 13.5036));
        cities.put("Luleå", new City("Luleå", 65.5848, 22.1567));
        cities.put("Trollhättan", new City("Trollhättan", 58.2831, 12.2884));
        cities.put("Umeå", new City("Umeå", 63.8258, 20.2630));
        cities.put("Borås", new City("Borås", 57.7210, 12.9401));
        cities.put("Sundsvall", new City("Sundsvall", 62.3908, 17.3069));
        cities.put("Gävle", new City("Gävle", 60.6745, 17.1419));
        cities.put("Östersund", new City("Östersund", 63.1767, 14.6366));
        cities.put("Varberg", new City("Varberg", 57.1054, 12.2521));
        cities.put("Haninge", new City("Haninge", 59.1619, 18.1243));
        cities.put("Sollentuna", new City("Sollentuna", 59.4285, 17.9503));
        cities.put("Abisko", new City("Abisko", 68.3575, 18.8042));
        cities.put("Vänersborg", new City("Vänersborg", 58.3702, 12.3235));
        cities.put("Hudiksvall", new City("Hudiksvall", 61.7286, 17.1033));
        cities.put("Sala", new City("Sala", 59.9093, 16.6109));
        cities.put("Värnamo", new City("Värnamo", 57.1864, 14.0300));
        cities.put("Kungsbacka", new City("Kungsbacka", 57.4878, 12.0763));
        cities.put("Nacka", new City("Nacka", 59.3092, 18.1636));
        cities.put("Karlskrona", new City("Karlskrona", 56.1616, 15.5866));
        cities.put("Kristianstad", new City("Kristianstad", 56.0313, 14.1524));
        cities.put("Skellefteå", new City("Skellefteå", 64.7507, 20.9528));
        cities.put("Trelleborg", new City("Trelleborg", 55.3753, 13.1569));
        cities.put("Alingsås", new City("Alingsås", 57.9303, 12.5343));
        cities.put("Lidingö", new City("Lidingö", 59.3667, 18.1333));
        cities.put("Sandviken", new City("Sandviken", 60.6167, 16.7667));
        cities.put("Visby", new City("Visby", 57.6409, 18.2960));
        cities.put("Katrineholm", new City("Katrineholm", 58.9959, 16.2070));
        cities.put("Vallentuna", new City("Vallentuna", 59.5333, 18.0833));
        cities.put("Märsta", new City("Märsta", 59.6167, 17.8500));
        cities.put("Kungälv", new City("Kungälv", 57.8667, 11.9667));
        cities.put("Boden", new City("Boden", 65.8252, 21.6887));
        cities.put("Eslöv", new City("Eslöv", 55.8394, 13.3036));
        cities.put("Falkenberg", new City("Falkenberg", 56.9055, 12.4918));
        cities.put("Ljungby", new City("Ljungby", 56.8333, 13.9333));
        cities.put("Mariestad", new City("Mariestad", 58.7053, 13.8237));
        cities.put("Motala", new City("Motala", 58.5372, 15.0364));
        cities.put("Nässjö", new City("Nässjö", 57.6533, 14.6967));
        cities.put("Nynäshamn", new City("Nynäshamn", 58.9025, 17.9478));
        cities.put("Söderhamn", new City("Söderhamn", 61.3033, 17.0625));
        cities.put("Strängnäs", new City("Strängnäs", 59.3775, 17.0319));

        
        addCityAlias("Göteborg", "Götet");
        addCityAlias("Malmö", "Möllan");
        addCityAlias("Kiruna", "Kiran");
        addCityAlias("Växjö", "Växjöv");
        addCityAlias("Mölndal", "Mölndalv");
    }

    private void addCityAlias(String göteborg, String götet) {
    }

    public static City getCity(String cityName) {
        // TODO: Skriv din kod här
        cityName = cityName.substring(0, 1).toUpperCase() + cityName.substring(1).toLowerCase();
        return cities.get(cityName);
    }
    //here we should think about if the city is not in the list could we check the latitude and longitude of the city and return the city name

    public City getCity(double latitude, double longitude) {
        if (latitude < 0 || longitude < 0) {
            throw new IllegalArgumentException("Latitude and longitude must be positive.");
        }
        for (City city : cities.values()) {
            if (city.getLatitude() == latitude && city.getLongitude() == longitude) {
                return city;
            }
            //here should we return with new city name some input such as Copenhagen?


        }
        return new City("Unknown", latitude, longitude);
}
 public boolean addCity(String cityName) {
        if (cityName == null) {
            throw new IllegalArgumentException("City name cannot be null.");
        }
        addCity = getCity(cityName);
        if (addCity != null) {
            return false;
        }
        return true;
 }
}
