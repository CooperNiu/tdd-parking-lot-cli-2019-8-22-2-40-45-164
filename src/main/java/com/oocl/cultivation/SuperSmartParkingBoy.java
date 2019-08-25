package com.oocl.cultivation;

import java.util.ArrayList;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot pickParkingLot() {
        if (parkingLots.size() == 0) {
            return null;
        }
        if (parkingLots.size() == 1) {
            if (parkingLots.get(0).getCurrentParkingSpace() > 0) {
                return parkingLots.get(0);
            } else {
                return null;
            }
        } else {
            ParkingLot parkingLotWithMoreSpaceRate = null;
            for (ParkingLot parkingLot : parkingLots) {
                if (parkingLot.getCurrentParkingSpace() > 0) {
                    if (parkingLotWithMoreSpaceRate == null) {
                        parkingLotWithMoreSpaceRate = parkingLot;
                    } else {
                        if (parkingLot.getCurrentParkingSpace() > parkingLotWithMoreSpaceRate.getCurrentParkingSpace()) {
                            parkingLotWithMoreSpaceRate = parkingLot;
                        }
                    }
                }
            }
            if (parkingLotWithMoreSpaceRate == null) {
                return null;
            } else {
                return parkingLotWithMoreSpaceRate;
            }
        }
    }

}