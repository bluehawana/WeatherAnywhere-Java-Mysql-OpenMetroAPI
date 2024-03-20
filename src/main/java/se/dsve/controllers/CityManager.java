package se.dsve.controllers;

import se.dsve.models.City;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the cities and their corresponding geographical data.
 * Hanterar städer och deras geografiska data.
 */
public class CityManager {
    private final Map<String, City> cities = new HashMap<>();

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
        cities.put("Kiran", new City("Kiruna", 67.8557, 20.2253));
        
        
        addCityAlias("Göteborg", "Götet");
        addCityAlias("Malmö", "Möllan");
        addCityAlias("Kiruna", "Kiran");
        addCityAlias("Växjö", "Växjöv");
    }

    private void addCityAlias(String göteborg, String götet) {
    }

    public City getCity(String cityName) {
        // TODO: Skriv din kod här
        cityName = cityName.substring(0, 1).toUpperCase() + cityName.substring(1).toLowerCase();
        return cities.get(cityName);
    }
}
