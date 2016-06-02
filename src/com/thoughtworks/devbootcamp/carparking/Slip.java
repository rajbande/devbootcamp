package com.thoughtworks.devbootcamp.carparking;

import com.thoughtworks.devbootcamp.carparking.models.Token;

public class Slip {
  private int parkedLotId;
  private Token parkingLotToken;

  public Slip(int parkedLotId, Token parkingLotToken) {
    this.parkedLotId = parkedLotId;
    this.parkingLotToken = parkingLotToken;
  }

  public int getParkedLotId() {
    return parkedLotId;
  }

  public Token getParkingLotToken() {
    return parkingLotToken;
  }
}
