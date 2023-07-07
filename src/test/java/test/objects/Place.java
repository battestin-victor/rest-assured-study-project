package test.objects;

import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder({"placeName","longitude","state","stateAbbreviation","latitude"})
public class Place {

    private String placeName;
    private String longitude;
    private String state;
    private String stateAbbreviation;
    private String latitude;

    public Place(){
        this.placeName = "São Paulo";
        this.longitude = "-46.635";
        this.state = "Sao Paulo";
        this.stateAbbreviation = "27";
        this.latitude = "-23.627";
    }

    @JsonProperty("place name")
    public String getPlaceName() {
        return placeName;
    }

    @JsonProperty("place name")
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("state abbreviation")
    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    @JsonProperty("state abbreviation")
    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
