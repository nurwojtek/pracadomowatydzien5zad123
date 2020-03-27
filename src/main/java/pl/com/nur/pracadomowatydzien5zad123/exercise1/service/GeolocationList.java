package pl.com.nur.pracadomowatydzien5zad123.exercise1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.com.nur.pracadomowatydzien5zad123.exercise1.model.Geolocation;
import pl.com.nur.pracadomowatydzien5zad123.exercise1.model.IpAddressList;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeolocationList {

    List<Geolocation> geolocationList;
    RestTemplate restTemplate;    // do ściagania api
    IpAddressList ipAddressList;

    @Autowired
    public GeolocationList(IpAddressList ipAddressList) {
        this.ipAddressList = ipAddressList;
        geolocationList = new ArrayList();
        restTemplate = new RestTemplate();
        get();
    }


    public void get() {
        for (int i = 0; i < ipAddressList.getAddressList().size(); i++) {
            String url = "https://api.ip2country.info/ip?" + ipAddressList.getAddressList().get(i);
            Geolocation forObject = restTemplate.getForObject(url, Geolocation.class);
            forObject.setUrl(ipAddressList.getAddressList().get(i));
            geolocationList.add(forObject);
        }
    }

    public void getIpAddress(IpAddressList ipAddressList){
        String url = "https://api.ip2country.info/ip?" + ipAddressList.getIpaddress();
        Geolocation forObject = restTemplate.getForObject(url, Geolocation.class);
        forObject.setUrl(ipAddressList.getIpaddress());
        geolocationList.add(forObject);
    }

    public List<Geolocation> getList(){
        return geolocationList;
    }



}
