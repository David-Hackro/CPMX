package hackro.com.att.Entities;

import java.util.ArrayList;

/**
 * Created by hackro on 2/01/16.
 */
public  class  statusReport {

    static ArrayList<stops> stops;
    static String currentlyStoppedAtBusStop;
    static String currentStopId;
    static String routeId;
    static String requestTime;
    static String status;
    static String requestType;

    public statusReport(ArrayList<hackro.com.att.Entities.stops> stops, String currentlyStoppedAtBusStop, String currentStopId, String routeId, String requestTime, String status, String requestType) {
        this.stops = stops;
        this.currentlyStoppedAtBusStop = currentlyStoppedAtBusStop;
        this.currentStopId = currentStopId;
        this.routeId = routeId;
        this.requestTime = requestTime;
        this.status = status;
        this.requestType = requestType;
    }

    public statusReport() {
    }

    public ArrayList<hackro.com.att.Entities.stops> getStops() {
        return stops;
    }

    public void setStops(ArrayList<hackro.com.att.Entities.stops> stops) {
        this.stops = stops;
    }

    public String getCurrentlyStoppedAtBusStop() {
        return currentlyStoppedAtBusStop;
    }

    public void setCurrentlyStoppedAtBusStop(String currentlyStoppedAtBusStop) {
        this.currentlyStoppedAtBusStop = currentlyStoppedAtBusStop;
    }

    public String getCurrentStopId() {
        return currentStopId;
    }

    public void setCurrentStopId(String currentStopId) {
        this.currentStopId = currentStopId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}
