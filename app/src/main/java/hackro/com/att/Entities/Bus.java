package hackro.com.att.Entities;

/**
 * Created by hackro on 2/01/16.
 */
public class Bus {

    private Integer id;
    private String vim;
    private Integer MaxPeople;
    private Integer Numberpassanger;
    private Integer CurrentAvailability;
    private float latitude;
    private float longitude;



    public Bus(Integer id, String vim, Integer maxPeople, Integer numberpassanger, Integer currentAvailability, float latitude, float longitude) {
        this.id = id;
        this.vim = vim;
        MaxPeople = maxPeople;
        Numberpassanger = numberpassanger;
        CurrentAvailability = currentAvailability;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Bus() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVim() {
        return vim;
    }

    public void setVim(String vim) {
        this.vim = vim;
    }

    public Integer getMaxPeople() {
        return MaxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        MaxPeople = maxPeople;
    }

    public Integer getNumberpassanger() {
        return Numberpassanger;
    }

    public void setNumberpassanger(Integer numberpassanger) {
        Numberpassanger = numberpassanger;
    }

    public Integer getCurrentAvailability() {
        return CurrentAvailability;
    }

    public void setCurrentAvailability(Integer currentAvailability) {
        CurrentAvailability = currentAvailability;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }


    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
