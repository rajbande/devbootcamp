package com.thoughtworks.devbootcamp.carparking;

import com.thoughtworks.devbootcamp.carparking.exceptions.CarParkException;
import com.thoughtworks.devbootcamp.carparking.exceptions.CarRetrievalException;
import com.thoughtworks.devbootcamp.carparking.exceptions.ParkingLotFullException;
import com.thoughtworks.devbootcamp.carparking.models.Token;

import java.util.HashMap;
import java.util.Map;

public class ParkingLots {
  private Map<Integer, ParkingLot> parkingLots;
  private Map<Object,Slip> slipMap;


  public ParkingLots(Map<Integer, ParkingLot> parkingLotsList) {
    slipMap = new HashMap<>(parkingLotsList.size());
    parkingLots = parkingLotsList;
  }

  public int getParkingLotCount() {
    return parkingLots.size();
  }

  public Token park(String regNo) throws CarParkException, ParkingLotFullException {
    ParkingLot freeParkingLot = getFreeParkingLot();

    if(carAlreadyParked(regNo)) {
      throw new CarParkException("Car already parked");
    }

    Token parkingLotToken = freeParkingLot.park(regNo);

    Token newToken = new Token();

    slipMap.put(newToken, new Slip(freeParkingLot.getParkingLotId(), parkingLotToken));

    return newToken;
  }

  private boolean carAlreadyParked(String regNo) {
    for (ParkingLot parkingLot : parkingLots.values()) {
      if(parkingLot.isCarAlreadyParked(regNo)) {
        return true;
      }
    }
    return false;
  }

  private ParkingLot getFreeParkingLot() throws ParkingLotFullException {
    for (ParkingLot parkingLot : parkingLots.values()) {
      if(parkingLot.isParkingAvailable()) {
        return parkingLot;
      }
    }
    throw new ParkingLotFullException();
  }

  public String retrieve(Token token) throws CarRetrievalException {
    Slip slip = slipMap.get(token);
    if(slip == null) throw new CarRetrievalException();
    return getParkedCar(slip);
  }

  private String getParkedCar(Slip slip) throws CarRetrievalException {
    Token parkingLotToken = slip.getParkingLotToken();
    int parkedLotId = slip.getParkedLotId();
    ParkingLot parkingLot = parkingLots.get(parkedLotId);
    return parkingLot.retrieve(parkingLotToken);
  }
}
