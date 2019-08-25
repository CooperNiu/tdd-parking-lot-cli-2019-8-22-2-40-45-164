package com.oocl.cultivation;

public class ParkingTicket {
    private String ticketID;
    private ParkingLot parkingLot;

    public ParkingTicket(){

    }

    public ParkingTicket(String ticketID, ParkingLot parkingLot)
    {
        this.parkingLot = parkingLot;
        this.ticketID = ticketID;
    }

    public ParkingLot getParkingLot(){
        return parkingLot;
    }

}
