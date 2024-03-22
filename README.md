# Weather Searching App
This application is a development from a Swedish weather searching app. It is designed to provide weather information for various cities, with a focus on Swedish cities. The application uses latitude and longitude for weather data retrieval, as the weather API only supports location-based searches.  

## City Manager
The CityManager class is responsible for managing the cities. It stores Swedish cities along with their respective latitude and longitude coordinates. This data is used to fetch weather information from the weather API.  

## OpenCageData API
To enhance the functionality of the application, the OpenCageData API is used. This API allows the conversion of city names into geographical coordinates (latitude and longitude). When a new city is inputted, the OpenCageData API is used to obtain the city's coordinates. These coordinates are then stored in the MySQL weather database, specifically in the weather table. The table stores the city name, latitude, and longitude.  

## Open-Meteo.com
The application uses the Open-Meteo.com API to fetch weather information using the latitude and longitude of a city. When a city name is inputted, the application first checks if the city's coordinates are already stored in the database. If they are, the application fetches the weather information directly from Open-Meteo.com using these coordinates. If the city's coordinates are not in the database, the application uses the OpenCageData API to obtain the coordinates, stores them in the database, and then fetches the weather information from Open-Meteo.com.  

## Usage
To use the application, simply input the name of the city you want to check the weather for. The application will handle the rest, providing you with the current weather information for that city.  

## Development
This application was developed with Java and Maven. It uses MySQL for database management and interacts with the OpenCageData and Open-Meteo.com APIs for data retrieval. The core logic is to acheive the goal of checking weather in any city in the world by input it. Later there will be an Andriod and iOS versions as well and they will keep the same black-white console style.  

## Future Improvements
Future improvements to this application could include expanding the list of cities, improving the user interface, and adding more detailed weather information.

## Licens

Licensen finns i filen [LICENSE.md](LICENSE).
