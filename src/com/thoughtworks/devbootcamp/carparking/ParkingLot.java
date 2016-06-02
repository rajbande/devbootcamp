package com.thoughtworks.devbootcamp.carparking;

import com.thoughtworks.devbootcamp.carparking.exceptions.CarParkException;
import com.thoughtworks.devbootcamp.carparking.exceptions.CarRetrievalException;
import com.thoughtworks.devbootcamp.carparking.exceptions.ParkingLotFullException;
import com.thoughtworks.devbootcamp.carparking.models.Token;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

  private int parkingLotId;
  private int parkingLotCapacity;
  private Map<Token, String> carsParked;

  public ParkingLot(int parkingLotId, Integer parkingLotCapacity) {
    carsParked = new HashMap<>(parkingLotCapacity);
    this.parkingLotId = parkingLotId;
    this.parkingLotCapacity = parkingLotCapacity;
  }

  public boolean isParkingAvailable() {
    return parkingLotCapacity - carsParked.size() > 0;
  }

  public Token park(String regNo) throws CarParkException, ParkingLotFullException {
    if (isCarAlreadyParked(regNo)) {
      throw new CarParkException("Car already parked");
    }
    if (!isParkingAvailable()) {
      throw new ParkingLotFullException();
    }
    Token token = new Token();
    carsParked.put(token, regNo);

    return token;
  }

  private boolean isCarAlreadyParked(String regNo) {
    return carsParked.containsValue(regNo);
  }

  public String retrieve(Token token) throws CarRetrievalException {
    if (!carsParked.containsKey(token)) {
      throw new CarRetrievalException();
    }
    return carsParked.remove(token);
  }

  public int getParkingLotId() {
    return parkingLotId;
  }
}
