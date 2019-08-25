package com.oocl.cultivation;

import gherkin.lexer.Pa;
import sun.security.krb5.internal.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();
    private static AtomicLong idCounter = new AtomicLong();

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingTicket storeCar(Car car){
        ParkingTicket parkingTicket = new ParkingTicket(createTicketID());
        cars.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car pickCar(ParkingTicket ticket){
        cars.remove(ticket);
        return cars.get(ticket);
    }

    public boolean isParkingLotHasCar(Ticket ticket){
        return cars.containsKey(ticket);
    }

    private static String createTicketID()
    {
        String prefix = "T-";
        String id = String.valueOf(idCounter.getAndIncrement());
        id = String.format("%6s", id).replace(' ', '0');
        String ticketID = prefix + id;
        return ticketID;
    }

    public int getAvailablePosition() {
        return cars.size() - capacity;
        return capacity - cars.size();
    }
}

