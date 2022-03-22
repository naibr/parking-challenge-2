package com.nology;

public class ParkingSpot {
    private String type;
    private Vehicle vehicle;
    private Boolean free;

    public ParkingSpot(String type) {
        this.type = type;
     }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }
}
