package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingBoy {
    protected final ArrayList<ParkingLot> parkingLots;
    protected static String lastErrorMessage;
    public ParkingBoy(ArrayList<ParkingLot> parkingLots)
    {
        this.parkingLots = parkingLots;
    }

    public ParkingLot pickParkingLot(){
        if (parkingLots.size() == 1){
            return parkingLots.get(0).getAvailableParkingPosition() > 0 ? parkingLots.get(0) : null;
        }
        else {
            for (ParkingLot parkingLot : parkingLots)
            {
                if (parkingLot.getAvailableParkingPosition() > 0)
                {
                    return parkingLot;
                }
            }
            return null;
        }
    }

    public ParkingTicket park(Car car) {
        ParkingLot availableParkingLot = pickParkingLot();
        if (availableParkingLot != null) {
            lastErrorMessage = null;
            return availableParkingLot.storeCar(car);
        }else{
            lastErrorMessage = "The parking lot is full.";
            return null;
        }
    }

    public Car fetch(ParkingTicket ticket) {
        if (ticket != null)
        {
            if (ticket.getParkingLot() != null && ticket.getParkingLot().isParkingLotContainsCar(ticket)) {
                ParkingLot parkingLot = ticket.getParkingLot();
                lastErrorMessage = null;
                return parkingLot.pickCar(ticket);
            }
            else{
                lastErrorMessage = "Unrecognized parking ticket.";
            }
        }
        return null;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
