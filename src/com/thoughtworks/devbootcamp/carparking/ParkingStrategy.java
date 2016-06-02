package com.thoughtworks.devbootcamp.carparking;

import com.thoughtworks.devbootcamp.carparking.exceptions.ParkingLotFullException;

import java.util.Map;

public interface ParkingStrategy {
  public ParkingLot findParkingLot(Map<Integer, ParkingLot> parkingLots) throws ParkingLotFullException;
}
