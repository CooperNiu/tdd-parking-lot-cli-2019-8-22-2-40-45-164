package com.oocl.cultivation;

import javax.crypto.interfaces.PBEKey;
import java.util.ArrayList;

public class ParkingLotManager {
    ArrayList<ParkingBoy> parkingBoys;

    public ParkingLotManager(ArrayList<ParkingLot> parkingLots, ArrayList<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public ParkingTicket tellParkingBoy2Park(ParkingBoy parkingBoy, Car car) {
        if(checkIfParkingBoyUnderCmd(parkingBoy))
        {
            return parkingBoy.park(car);
        }
        else {
            return null;
        }
    }

    public Car tellParkingBoy2FetchCar(ParkingBoy parkingBoy, ParkingTicket parkingTicket){
        return parkingBoy.fetch(parkingTicket);
    }

    private boolean checkIfParkingBoyUnderCmd(ParkingBoy parkingBoy)
    {
        return this.parkingBoys.contains(parkingBoy);
    }
}
