package com.thoughtworks.devbootcamp.carparking;

import java.util.Map;

public class MostOccupiedParkingLotStrategy implements ParkingStrategy {
  @Override
  public ParkingLot findParkingLot(Map<Integer, ParkingLot> parkingLots) {
    ParkingLot mostOccupiedParkingLot = null;
    double lastMaximumOccupancy = 0d;

    int startingIndex = parkingLots.size() - 1;
    for (int i = startingIndex; i >= 0; i--) {
      ParkingLot parkingLot = parkingLots.get(i);
      double parkingOccupancy = parkingLot.getParkingOccupancy();
      if(parkingLot.isParkingAvailable()) {
        if(parkingOccupancy >= lastMaximumOccupancy) {
          lastMaximumOccupancy = parkingOccupancy;
          mostOccupiedParkingLot = parkingLot;
        }
      }
    }

    return mostOccupiedParkingLot;
  }
}
