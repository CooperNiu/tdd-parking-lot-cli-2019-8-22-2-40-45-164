package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return cars.size() - capacity;
    }

	@SuppressWarnings("unchecked")
	public ParkingTicket parkCar(Car car) {
		ParkingTicket parkingTicket = new ParkingTicket();
		this.cars = (Map<ParkingTicket, Car>) cars.put(parkingTicket, car);
		return parkingTicket;
	}

	public Car pickCar(ParkingTicket parkingTicket) {
		// TODO Auto-generated method stub
		return new Car();
	}
}
