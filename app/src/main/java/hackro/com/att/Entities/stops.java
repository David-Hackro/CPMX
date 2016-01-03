package hackro.com.att.Entities;

/**
 * Created by hackro on 2/01/16.
 */
public class stops {

    private String  stopName;
    private String shelter;
    private String bench;
    private String stopId;
    private String odom;
    private String load;
    private String longitud;
    private String lat;

    public stops(String stopName, String shelter, String bench, String stopId, String odom, String load, String longitud, String lat) {
        this.stopName = stopName;
        this.shelter = shelter;
        this.bench = bench;
        this.stopId = stopId;
        this.odom = odom;
        this.load = load;
        this.longitud = longitud;
        this.lat = lat;
    }

    public stops() {
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getShelter() {
        return shelter;
    }

    public void setShelter(String shelter) {
        this.shelter = shelter;
    }

    public String getBench() {
        return bench;
    }

    public void setBench(String bench) {
        this.bench = bench;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getOdom() {
        return odom;
    }

    public void setOdom(String odom) {
        this.odom = odom;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "stops{" +
                "stopName='" + stopName + '\'' +
                ", shelter='" + shelter + '\'' +
                ", bench='" + bench + '\'' +
                ", stopId='" + stopId + '\'' +
                ", odom='" + odom + '\'' +
                ", load='" + load + '\'' +
                ", longitud='" + longitud + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }
}
