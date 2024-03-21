package se.dsve.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.dsve.models.City;
import se.dsve.models.WeatherInfo;

class WeatherAPIClientTest {

    private WeatherAPIClient weatherAPIClient;

    @BeforeEach
    void setUp() {
        // Initialize your WeatherAPIClient before each test
        weatherAPIClient = new WeatherAPIClient();
    }

    @Test
    void testFetchWeatherWithValidCity() {
        // Assume we have a City class with a name, latitude, and longitude
        City testCity = new City("Stockholm", 59.3293, 18.0686);

        // Attempt to fetch weather for the given city
        WeatherInfo weatherInfo = null;
        try {
            weatherInfo = weatherAPIClient.fetchWeather(testCity);
        } catch (Exception e) {
            fail("Fetching weather caused an exception: " + e.getMessage());
        }

        // Perform assertions to verify correct behavior
        assertNotNull(weatherInfo, "WeatherInfo should not be null for a valid city");
        // Additional assertions can be added to verify specific properties of the WeatherInfo object
    }

    @Test
    void testFetchWeatherWithInvalidCity() {
        // Example of an invalid city (assuming invalid means null for this test case)
        City invalidCity = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            weatherAPIClient.fetchWeather(null);
        });

        String expectedMessage = "City cannot be null.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Exception message should indicate the city cannot be null");
    }

    // Additional tests can be added here to cover more scenarios
}
