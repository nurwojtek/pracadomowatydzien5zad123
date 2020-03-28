package pl.com.nur.pracadomowatydzien5zad123.exercise2.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.com.nur.pracadomowatydzien5zad123.exercise1.model.IpAddressList;
import pl.com.nur.pracadomowatydzien5zad123.exercise2.model.City;
import pl.com.nur.pracadomowatydzien5zad123.exercise2.service.WeatherCity;

@Controller
@RequestMapping("/weather-city")
public class WeatherApi {

    WeatherCity weatherCity;

    public WeatherApi(WeatherCity weatherCity) {
        this.weatherCity = weatherCity;
    }


    @GetMapping
    public String getCity(Model model){
        model.addAttribute("weatherCity",weatherCity.getWeather());
        model.addAttribute("city", new City());
        model.addAttribute("weatherIcon",weatherCity.getIcon());
        model.addAttribute("mapweather", weatherCity.getMap());  // dla https://leafletjs.com/
        return "weather";
    }


    @PostMapping
    public String addVehicle(@ModelAttribute City search) {
        System.out.println("do post wpada" + search);
        weatherCity.getCity(search.getTitle());    // z nowego miasta wiczytuje jego nazwę :D
        return "redirect:/weather-city";
    }
}
