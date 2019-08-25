package com.oocl.cultivation;

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
        ParkingTicket parkingTicket = new ParkingTicket(createTicketID(), this);
        this.cars.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car pickCar(ParkingTicket ticket){
        Car car = this.cars.get(ticket);
        this.cars.remove(ticket);
        return car;
    }

    public boolean isParkingLotContainsCar(ParkingTicket ticket){
        return this.cars.containsKey(ticket);
    }

    private static String createTicketID()
    {
        String prefix = "T-";
        String id = String.valueOf(idCounter.getAndIncrement());
        id = String.format("%6s", id).replace(' ', '0');
        String ticketID = prefix + id;
        return ticketID;
    }

    public double getCurrentParkingSpace()
    {
        if (capacity - cars.size() == 0)
        {
            return 0;
        }
        return (capacity - cars.size()) / (capacity * 1.0);
    }

    public int getAvailableParkingPosition() {
        return cars.size() - capacity;
    }
}

