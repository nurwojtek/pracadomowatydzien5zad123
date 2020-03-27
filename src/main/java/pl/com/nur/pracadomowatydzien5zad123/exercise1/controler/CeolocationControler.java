package pl.com.nur.pracadomowatydzien5zad123.exercise1.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.nur.pracadomowatydzien5zad123.exercise1.model.Geolocation;
import pl.com.nur.pracadomowatydzien5zad123.exercise1.model.IpAddressList;
import pl.com.nur.pracadomowatydzien5zad123.exercise1.service.GeolocationList;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/geolocation")
public class CeolocationControler {

    GeolocationList geolocationList;

    public CeolocationControler(GeolocationList geolocationList) {
        this.geolocationList = geolocationList;
    }



    @GetMapping()
    public String getListGeo(Model model){
        model.addAttribute("ipgeoloc", geolocationList.getList());
        model.addAttribute("newip", new IpAddressList());
        return "ipgeolocation";
    }


    @PostMapping("/ip")
    public String addVehicle(@ModelAttribute IpAddressList newip) {
        geolocationList.getIpAddress(newip);
        return "redirect:/geolocation";
    }
}
