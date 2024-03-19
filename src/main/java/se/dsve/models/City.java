package se.dsve.models;

/**
 * Represents a city with its name and geographical coordinates.
 * Används för att lagra information om städer och deras geografiska koordinater.
 */
public class City {
    private final String name;
    private final double latitude;
    private final double longitude;

    /**
     * Constructs a new City instance.
     * @param name Namnet på staden.
     * @param latitude Stadens latitud.
     * @param longitude Stadens longitud.
     */
    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        // TODO: Skriv din kod här
        return null;
    }

    public double getLatitude() {
        // TODO: Skriv din kod här
        return -1;
    }

    public double getLongitude() {
        // TODO: Skriv din kod här
        return -1;
    }
}
