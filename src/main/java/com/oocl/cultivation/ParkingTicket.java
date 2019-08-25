package com.oocl.cultivation;

public class ParkingTicket {
    private String ticketID;

    public ParkingTicket(){

    }

    public ParkingTicket(String ticketID){
        this.ticketID = ticketID;
    }

    public ParkingTicket generateTicket(){
        return this;
    }
}
