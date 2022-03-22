package com.nology;

public class Main {

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10,10,0);

        Vehicle van = new Vehicle("Van");

        parkingLot.park(van);
        parkingLot.park(van);
        parkingLot.park(van);
        parkingLot.spotsRemaining();
        parkingLot.totalSpots();
        parkingLot.emptyLot();
        parkingLot.fullLot();

    }
}
