package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
    	return parkingLot.parkCar(car);
    }

    public Car fetch(ParkingTicket ticket) {
        return parkingLot.pickCar(ticket);
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
