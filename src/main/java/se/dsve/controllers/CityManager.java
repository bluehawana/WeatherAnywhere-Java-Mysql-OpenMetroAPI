package se.dsve.controllers;

import se.dsve.models.City;

import java.util.HashMap;
import java.util.Map;


public class CityManager {
    private static final Map<String, City> cities = new HashMap<>();
    private City addCity;

    //Initializes the city manager with predefined cities.
    public CityManager() {
        cities.put("Stockholm", new City("Stockholm", 59.3293, 18.0686));
        cities.put("Göteborg", new City("Göteborg", 57.7089, 11.9746));
        cities.put("Malmö", new City("Malmö", 55.6044, 13.0038));
        cities.put("Kiruna", new City("Kiruna", 67.8557, 20.2255));
        cities.put("Växjö", new City("Växjö", 56.8777, 14.8094));
        cities.put("Mölndal", new City("Mölndal", 57.6584, 12.0022));
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