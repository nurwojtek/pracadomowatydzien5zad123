package pl.com.nur.pracadomowatydzien5zad123.exercise2.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.com.nur.pracadomowatydzien5zad123.exercise2.model.City;
import pl.com.nur.pracadomowatydzien5zad123.exercise2.model.weatherpojo.ConsolidatedWeather;
import pl.com.nur.pracadomowatydzien5zad123.exercise2.model.weatherpojo.Weather;

@Service
public class WeatherCity {

    private String startCity = "Warsaw";
    private Integer startCityWoeid = 523920;

    City city;
    Weather weather;
    ConsolidatedWeather consolidatedWeather;


    public WeatherCity(){
        city = new City();
        weather = new Weather();
        consolidatedWeather = new ConsolidatedWeather();

        ///////Testy///////
        getCity("London"); 
        getWeather();
    }

    public void getCity(String searchCity){
        City selectedCity = new City();
        HttpEntity httpEntity = new HttpEntity(selectedCity);
        String urlCity= "https://www.metaweather.com/api/location/search/?query=" + searchCity;
        System.out.println(urlCity);

        RestTemplate restTemplateCity = new RestTemplate();
        ResponseEntity<City[]> responseEntity = restTemplateCity.exchange(
                String.format(urlCity),
                HttpMethod.GET,
                httpEntity,
                City[].class);

        if (responseEntity.getBody().length != 0) {
            this.city = responseEntity.getBody()[0];
            this.city.setWoeid(responseEntity.getBody()[0].getWoeid());
        }
        else {
            city.setTitle(startCity);
            city.setWoeid(startCityWoeid);
        }
        System.out.println(city);
    }


    public void getWeather() {
        Weather weathernew = new Weather();
        HttpEntity httpEntity = new HttpEntity(weathernew);
        RestTemplate restTemplate = new RestTemplate();

        String urlCity= "https://www.metaweather.com/api/location/" + city.getWoeid();
        System.out.println(urlCity);
        ResponseEntity<String> weatherResponseEntity = restTemplate.exchange(
                String.format(urlCity),
                HttpMethod.GET,
                httpEntity,
                String.class);
        String ddd = weatherResponseEntity.getBody();
     //   this.weather = weatherResponseEntity.getBody();
        System.out.println(ddd);


    }

}
