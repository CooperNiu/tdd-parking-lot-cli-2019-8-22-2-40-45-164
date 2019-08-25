package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        int availablePos = parkingLot.getAvailablePosition();
        if (availablePos > 0) {
            lastErrorMessage = null;
            return this.parkingLot.storeCar(car);
        }else{
            lastErrorMessage = "";
            return null;
        }
    }

    public Car fetch(ParkingTicket ticket) {
        if (parkingLot.isParkingLotHasCar(ticket))
        {
            lastErrorMessage = null;
        }
        else{
            lastErrorMessage = "Unrecognised parking ticket.";

        }
        return null;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
