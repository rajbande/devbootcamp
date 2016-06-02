package com.thoughtworks.devbootcamp.carparking;

import java.util.Map;

public class LeastOccupiedParkingLotStrategy implements ParkingStrategy {
  @Override
  public ParkingLot findParkingLot(Map<Integer, ParkingLot> parkingLots) {
    ParkingLot leastOccupiedParkingLot = null;
    double lastMinimumOccupancy = 101d;

    for (ParkingLot parkingLot : parkingLots.values()) {
      double parkingOccupancy = parkingLot.getParkingOccupancy();
      if(parkingOccupancy == 0.0d) {
        return parkingLot;
      }
      if(parkingOccupancy < lastMinimumOccupancy) {
        lastMinimumOccupancy = parkingOccupancy;
        leastOccupiedParkingLot = parkingLot;
      }
    }

    return leastOccupiedParkingLot;
  }
}
