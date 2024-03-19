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
    }

    public City getCity(String cityName) {
        // TODO: Skriv din kod här
        return null;
    }
}
