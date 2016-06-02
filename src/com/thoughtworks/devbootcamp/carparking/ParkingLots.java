package com.thoughtworks.devbootcamp.carparking;

import com.thoughtworks.devbootcamp.carparking.exceptions.CarParkException;
import com.thoughtworks.devbootcamp.carparking.exceptions.CarRetrievalException;
import com.thoughtworks.devbootcamp.carparking.exceptions.ParkingLotFullException;
import com.thoughtworks.devbootcamp.carparking.models.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLots {
  private Map<Integer, ParkingLot> parkingLots;
  private Map<Object,Slip> slipMap;


  public ParkingLots(Integer... capacities) {
    createParkingLots(capacities);
  }

  private void createParkingLots(Integer[] capacities) {
    parkingLots = new HashMap<>(capacities.length);
    slipMap = new HashMap<>(capacities.length);

    for (int i = 0; i < capacities.length; i++) {
      parkingLots.put(i, new ParkingLot(i, capacities[i]));
    }
  }

  public int getParkingLotCount() {
    return parkingLots.size();
  }

  public Token park(String regNo) throws CarParkException, ParkingLotFullException {
    ParkingLot freeParkingLot = getFreeParkingLot();
    Token parkingLotToken = freeParkingLot.park(regNo);

    Token newToken = new Token();

    slipMap.put(newToken, new Slip(freeParkingLot.getParkingLotId(), parkingLotToken));

    return newToken;
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
