package pl.com.nur.pracadomowatydzien5zad123.exercise2.model;

public class DataForTheMap {
    String lattLong;
    String latt;
    String longg;


    String urlIcon;
    String weatherString;


    public DataForTheMap() {
        latt = "52.235352";
        longg = "21.009390";
    }




    public String getLattLong() {
        return lattLong;
    }

    public void setLattLong(String lattLong) {
        String[] latlon = lattLong.split("[,]");                //"\\|.|");
        System.out.println(" w parsowarni");
        setLatt(latlon[0]);
        setLongg(latlon[1]);
        System.out.println(" lat = " + getLatt());
        System.out.println(" long = " + latlon[1] );
        this.lattLong = lattLong;
    }

    public String getUrlIcon() {
        return urlIcon;
    }

    public void setUrlIcon(String urlIcon) {
        this.urlIcon = urlIcon;
    }

    public String getWeatherString() {
        return weatherString;
    }

    public void setWeatherString(String weatherString) {
        this.weatherString = weatherString;
    }

    public String getLatt() {
        return latt;
    }

    public String getLongg() {
        return longg;
    }

    public void setLatt(String latt) {
        this.latt = latt;
    }

    public void setLongg(String longg) {
        this.longg = longg;
    }
}
