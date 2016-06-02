package com.thoughtworks.devbootcamp.carparking;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AttendantTest {
  @Test
  public void test() {
    List<ParkingLot> parkingLots = someParkingLots();

    Attendant attendant = new Attendant();

  }

  private List<ParkingLot> someParkingLots(Integer... args) {
    List<ParkingLot> parkingLots = new LinkedList<>();

    for (int i = 0; i < args.length; i++) {
      parkingLots.add(new ParkingLot(i, args[i]));
    }
    return parkingLots;
  }
}
