package com.nology;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<CompactSpot> compactSpotsList = new ArrayList<>();
    List<RegularSpot> regularSpotsList = new ArrayList<>();
    List<LargeSpot> largeSpotsList = new ArrayList<>();

    int freeCompactSpots;
    int freeRegularSpots;
    int freeLargeSpots;

    public ParkingLot(int freeCompactSpots, int freeRegularSpots, int freeLargeSpots) {
        this.freeCompactSpots = freeCompactSpots;
        this.freeRegularSpots = freeRegularSpots;
        this.freeLargeSpots = freeLargeSpots;
    }

        public void park(Vehicle vehicle) {
        if (vehicle.getVehicleType().equals("Van")) {
            if (freeLargeSpots > 0) {
                parkLarge(vehicle);
                System.out.println("free large spots remaining: " + freeLargeSpots);
                System.out.println("number of large vehicles parked: " + largeSpotsList.size());
            } else if (freeRegularSpots >= 3) {
                parkRegular(vehicle);
                parkRegular(vehicle);
                parkRegular(vehicle);
            } else {
                System.out.println("no Van spots");
            }
        } else if (vehicle.getVehicleType().equals("Car")) {
            if (freeRegularSpots > 0) {
                parkRegular(vehicle);
            } else if (freeCompactSpots > 0) {
                parkCompact(vehicle);
            } else {
                    System.out.println("no regular or compact spots");
                }
        } else if (vehicle.getVehicleType().equals("motorbike")) {
            if (freeCompactSpots > 0) {
                parkCompact(vehicle);
            } else if (freeRegularSpots > 0) {
                parkRegular(vehicle);
            } else if (freeLargeSpots > 0) {
                parkLarge(vehicle);
            } else {
                    System.out.println("no spots");
            }
        }
    }

    public void parkLarge(Vehicle vehicle) {
        LargeSpot largeSpot = new LargeSpot("large");
        largeSpot.setFree(false);
        largeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(largeSpot);

        largeSpotsList.add(largeSpot);
        freeLargeSpots--;
    }

    public void parkRegular(Vehicle vehicle) {
        RegularSpot regularSpot = new RegularSpot("regular");
        regularSpot.setFree(false);
        regularSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(regularSpot);

        regularSpotsList.add(regularSpot);
        freeRegularSpots--;
    }

    public void parkCompact(Vehicle vehicle) {
        CompactSpot compactSpot = new CompactSpot("compact");
        compactSpot.setFree(false);
        compactSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(compactSpot);

        compactSpotsList.add(compactSpot);
        freeCompactSpots--;
    }

    public void spotsRemaining() {
        System.out.println("Total spots remaining: " + (freeLargeSpots + freeRegularSpots + freeCompactSpots));
        System.out.println("free large spots remaining: " + freeLargeSpots);
        System.out.println("free regular spots remaining: " + freeRegularSpots);
        System.out.println("free compact spots remaining: " + freeCompactSpots);

    }

    public void totalSpots() {
        int totalLargeSpots = freeLargeSpots + largeSpotsList.size();
        int totalRegularSpots = freeRegularSpots + regularSpotsList.size();
        int totalCompactSpots = freeCompactSpots + compactSpotsList.size();
        System.out.println("Total spots in lot: " + (totalLargeSpots + totalRegularSpots + totalCompactSpots));
    }

    public void fullLot() {
        if (freeLargeSpots == 0 && freeRegularSpots < 3) {
            System.out.println("Van spots full");
        } else if (freeRegularSpots + freeCompactSpots == 0) {
            System.out.println("Car spots are full");
        } else if ((freeLargeSpots + freeRegularSpots + freeCompactSpots) == 0) {
            System.out.println("Parking Lot Full");
        } else {
            System.out.println("Parking Lot not full");
        }
    }

    public void emptyLot() {
        if ((largeSpotsList.size() + regularSpotsList.size() + compactSpotsList.size()) == 0) {
            System.out.println("Parking Lot empty");
        } else {
            System.out.println("Parking Lot not empty");
        }
    }



}