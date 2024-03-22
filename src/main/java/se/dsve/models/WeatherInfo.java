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
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getDescription() {
        return description;
    }
    //after we got weather description, we need swedish translation to show the user
    public String getSwedishDescription() {
        switch (description) {
            // WEATHER_CODES.put(0, "Clear sky");
            //            WEATHER_CODES.put(1, "Mainly clear");
            //            WEATHER_CODES.put(2, "Partly cloudy");
            //            WEATHER_CODES.put(3, "Overcast");
            //            WEATHER_CODES.put(45, "Fog");
            //            WEATHER_CODES.put(48, "Depositing rime fog");
            //            WEATHER_CODES.put(51, "Drizzle: Light");
            //            WEATHER_CODES.put(53, "Drizzle: Moderate");
            //            WEATHER_CODES.put(55, "Drizzle: Dense intensity");
            //            WEATHER_CODES.put(56, "Freezing Drizzle: Light");
            //            WEATHER_CODES.put(57, "Freezing Drizzle: Dense intensity");
            //            WEATHER_CODES.put(61, "Rain: Slight");
            //            WEATHER_CODES.put(63, "Rain: Moderate");
            //            WEATHER_CODES.put(65, "Rain: Heavy intensity");
            //            WEATHER_CODES.put(66, "Freezing Rain: Light");
            //            WEATHER_CODES.put(67, "Freezing Rain: Heavy intensity");
            //            WEATHER_CODES.put(71, "Snow fall: Slight");
            //            WEATHER_CODES.put(73, "Snow fall: Moderate");
            //            WEATHER_CODES.put(75, "Snow fall: Heavy intensity");
            //            WEATHER_CODES.put(77, "Snow grains");
            //            WEATHER_CODES.put(80, "Rain showers: Slight");
            //            WEATHER_CODES.put(81, "Rain showers: Moderate");
            //            WEATHER_CODES.put(82, "Rain showers: Violent");
            //            WEATHER_CODES.put(85, "Snow showers: Slight");
            //            WEATHER_CODES.put(86, "Snow showers: Heavy");
            //            WEATHER_CODES.put(95, "Thunderstorm: Slight or moderate");
            //            WEATHER_CODES.put(96, "Thunderstorm with slight hail");
            //            WEATHER_CODES.put(99, "Thunderstorm with heavy hail");
            //we should generate swedish translation for each weather description
            case "Clear sky":
                return "Klart himmel";
            case "Mainly clear":
                return "Huvudsakligen klart";
            case "Partly cloudy":
                return "Delvis molnigt";
            case "Overcast":
                return "Mulet";
            case "Fog":
                return "Dimma";
            case "Depositing rime fog":
                return "Deposition rim dimma";
            case "Drizzle: Light":
                return "Duggregn: Lätt";
            case "Drizzle: Moderate":
                return "Duggregn: Måttlig";
            case "Drizzle: Dense intensity":
                return "Duggregn: Tät intensitet";
            case "Freezing Drizzle: Light":
                return "Frysande duggregn: Lätt";
            case "Freezing Drizzle: Dense intensity":
                return "Frysande duggregn: Tät intensitet";
            case "Rain: Slight":
                return "Regn: Lätt";
            case "Rain: Moderate":
                return "Regn: Måttlig";
            case "Rain: Heavy intensity":
                return "Regn: Kraftig intensitet";
            case "Freezing Rain: Light":
                return "Frysande regn: Lätt";
            case "Freezing Rain: Heavy intensity":
                return "Frysande regn: Kraftig intensitet";
            case "Snow fall: Slight":
                return "Snöfall: Lätt";
            case "Snow fall: Moderate":
                return "Snöfall: Måttlig";
            case "Snow fall: Heavy intensity":
                return "Snöfall: Kraftig intensitet";
            case "Snow grains":
                return "Snökorn";
            case "Rain showers: Slight":
                return "Regnskurar: Lätta";
            case "Rain showers: Moderate":
                return "Regnskurar: Måttliga";
            case "Rain showers: Violent":
                return "Regnskurar: Våldsamma";
            case "Snow showers: Slight":
                return "Snöskurar: Lätta";
            case "Snow showers: Heavy":
                return "Snöskurar: Kraftiga";
            case "Thunderstorm: Slight or moderate":
                return "Åskväder: Lätt eller måttlig";
            case "Thunderstorm with slight hail":
                return "Åskväder med lätt hagel";
            case "Thunderstorm with heavy hail":
                return "Åskväder med kraftigt hagel";
            default:
                return "Okänt väder";

        }
    }

}

