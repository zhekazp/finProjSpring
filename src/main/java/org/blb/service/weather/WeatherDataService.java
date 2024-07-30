package org.blb.service.weather;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.blb.DTO.weather.WeatherDataResponseDto;
import org.blb.DTO.weather.WeatherLatLonDTO;
import org.blb.models.weather.WeatherDataEntity;
import org.blb.repository.weather.WeatherRepository;
import org.blb.service.util.weatherMapping.WeatherConverter;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WeatherDataService implements WeatherDataServiceInterface{

    private final WeatherRepository repository;
    private final WeatherConverter weatherConverter;
    private final OutWeatherApi outWeatherApi;
    private final OutGeoLocationApi outGeoLocationApi;

    @Override
    @SneakyThrows
    public WeatherDataResponseDto getWeather(String ipAddress)  {
        // Get latitude and longitude from IP address
        WeatherLatLonDTO dto = getLatLonFromGeoLocation(ipAddress);

        // Retrieve weather data from database
        ArrayDeque<WeatherDataEntity> entityQueue = getFromDatabase(dto.getLat(), dto.getLon());

        if (!entityQueue.isEmpty()) {
            WeatherDataEntity latestWeatherData = entityQueue.getLast();
            LocalDateTime createdTime = latestWeatherData.getTimeCreate();

            long duration = Duration.between(createdTime, LocalDateTime.now()).toMinutes();

            // If the latest data is less than 10 minutes old, return it
            if (duration < 10) {
                return weatherConverter.fromEntityToDto(latestWeatherData);
            }
        }

        // Fetch new data from API and save to database
        WeatherDataResponseDto response = getFromApi(dto.getLat(), dto.getLon());
        repository.save(weatherConverter.fromDtoToEntity(response));
        return response;
    }

    private ArrayDeque<WeatherDataEntity> getFromDatabase(String lat, String lon) {
        return repository.findAllByLatitudeAndLongitude(lat, lon);
    }

    private WeatherDataResponseDto getFromApi(String lat, String lon) throws MalformedURLException, URISyntaxException {
        return outWeatherApi.receivedFromWeatherApi(lat,lon);
    }

    private WeatherLatLonDTO getLatLonFromGeoLocation(String ipAddress) {
        return outGeoLocationApi.getLatLonFromGeoLocation(ipAddress);
    }
}