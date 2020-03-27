package pl.com.nur.pracadomowatydzien5zad123.exercise1.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class IpAddressList {
    List<String> addressList;
    private String ipaddress;


    public IpAddressList() {
        addressList = new ArrayList<>();
        String addres1 = "185.208.164.135";
        String addres2 = "54.230.229.66";
        String addres3 = "5.6.7.8";
        String addres4 = "192.168.1.1";
        String addres5 = "1.2.3.4";
        addressList.add(addres1);
        addressList.add(addres2);
        addressList.add(addres3);
        addressList.add(addres4);
        addressList.add(addres5);
       // Stream.of(addressList).forEach(System.out::println);
    }

    public List<String> getAddressList() {
        return addressList;
    }


    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

}
