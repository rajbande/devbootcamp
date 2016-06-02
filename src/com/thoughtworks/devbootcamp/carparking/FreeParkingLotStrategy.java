package com.thoughtworks.devbootcamp.carparking;

import com.thoughtworks.devbootcamp.carparking.exceptions.ParkingLotFullException;

import java.util.Map;

public class FreeParkingLotStrategy implements ParkingStrategy {
  @Override
  public ParkingLot findParkingLot(Map<Integer, ParkingLot> parkingLots) throws ParkingLotFullException {
    for (ParkingLot parkingLot : parkingLots.values()) {
      if(parkingLot.isParkingAvailable()) {
        return parkingLot;
      }
    }
    throw new ParkingLotFullException();
  }
}
