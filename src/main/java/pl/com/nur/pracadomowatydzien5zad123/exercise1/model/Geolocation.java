package pl.com.nur.pracadomowatydzien5zad123.exercise1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "countryCode",
        "countryCode3",
        "countryName",
        "countryEmoji"
})
public class Geolocation {

    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("countryCode3")
    private String countryCode3;
    @JsonProperty("countryName")
    private String countryName;
    @JsonProperty("countryEmoji")
    private String countryEmoji;

    private String url;

    // @JsonIgnore
    // private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Geolocation() {
    }

    public Geolocation(String countryCode, String countryCode3, String countryName, String countryEmoji) {
        this.countryCode = countryCode;
        this.countryCode3 = countryCode3;
        this.countryName = countryName;
        this.countryEmoji = countryEmoji;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("countryCode3")
    public String getCountryCode3() {
        return countryCode3;
    }

    @JsonProperty("countryCode3")
    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    @JsonProperty("countryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("countryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("countryEmoji")
    public String getCountryEmoji() {
        return countryEmoji;
    }

    @JsonProperty("countryEmoji")
    public void setCountryEmoji(String countryEmoji) {
        this.countryEmoji = countryEmoji;
    }

    @Override
    public String toString() {
        return " IP: " + url + '\'' +
                "Geolocation " +
                "countryCode='" + countryCode + '\'' +
                ", countryCode3='" + countryCode3 + '\'' +
                ", countryName='" + countryName + '\'' +
                ", countryEmoji='" + countryEmoji + '\'' +
                '.';
    }

}
