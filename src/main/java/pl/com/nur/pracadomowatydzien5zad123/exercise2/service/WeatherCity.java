package pl.com.nur.pracadomowatydzien5zad123.exercise2.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.com.nur.pracadomowatydzien5zad123.exercise2.model.City;
import pl.com.nur.pracadomowatydzien5zad123.exercise2.model.DataForTheMap;
import pl.com.nur.pracadomowatydzien5zad123.exercise2.model.weatherpojo.ConsolidatedWeather;
import pl.com.nur.pracadomowatydzien5zad123.exercise2.model.weatherpojo.Weather;

@Service
public class WeatherCity {

    private String startCity = "Warsaw";
    private Integer startCityWoeid = 523920;
    private String lattlong = "52.235352, 21.009390";
    public String urlIcon;

    City city;
    Weather weather;
    ConsolidatedWeather consolidatedWeather;
    DataForTheMap dataForTheMap;


    public WeatherCity(){
        city = new City();
        weather = new Weather();
        consolidatedWeather = new ConsolidatedWeather();
        dataForTheMap = new DataForTheMap();
        city.setWoeid(startCityWoeid);

        ///////Testy///////
      //  getCity("London");
      //  getWeather();
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
            dataForTheMap.setLattLong(city.getLattLong());
        }
        else {
            city.setTitle(startCity);
            city.setWoeid(startCityWoeid);
            dataForTheMap.setLattLong(lattlong);
            dataForTheMap.setLatt("21.009390");
        }
        System.out.println(city);
    }


    public Weather getWeather() {
        Weather weathernew = new Weather();
        HttpEntity httpEntity = new HttpEntity(weathernew);
        RestTemplate restTemplate = new RestTemplate();

        String urlCity= "https://www.metaweather.com/api/location/" + city.getWoeid();
        System.out.println(urlCity);
        ResponseEntity<Weather> weatherResponseEntity = restTemplate.exchange(
                String.format(urlCity),
                HttpMethod.GET,
                httpEntity,
                Weather.class);
        this.weather = weatherResponseEntity.getBody();

        return weather;
    }

    public City getIcon(){
        String iconWeather = weather.getConsolidatedWeather().get(0).getWeatherStateAbbr();
        urlIcon = "https://www.metaweather.com/static/img/weather/ico/" + iconWeather + ".ico";
        city.setUrlWeather(urlIcon);
        dataForTheMap.setUrlIcon(urlIcon);
        return city;
    }

    public DataForTheMap getMap (){
        System.out.println( " Lat long " + lattlong);
        System.out.println("lat " + dataForTheMap.getLatt());
        System.out.println("long " + dataForTheMap.getLongg());
        return dataForTheMap;
    }

}
