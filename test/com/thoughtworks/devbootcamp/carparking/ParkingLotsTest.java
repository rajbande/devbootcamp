package com.thoughtworks.devbootcamp.carparking;

import com.thoughtworks.devbootcamp.carparking.exceptions.CarParkException;
import com.thoughtworks.devbootcamp.carparking.exceptions.CarRetrievalException;
import com.thoughtworks.devbootcamp.carparking.exceptions.ParkingLotFullException;
import com.thoughtworks.devbootcamp.carparking.models.Token;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ParkingLotsTest {
  private static final String REGISTRATION_NUMBER = "MH 12 KB 1055";

  @Test
  public void shouldCreateParkingLotsWithGivenCapacities() {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(1);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    assertThat(parkingLots.getParkingLotCount(), is(1));
  }

  @Test
  public void testParkingSuccessful() throws CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(1);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    assertNotNull(parkingLots.park(REGISTRATION_NUMBER));
  }

  @Test(expected = ParkingLotFullException.class)
  public void testCannotParkIfParkingLotsHasZeroCapacity() throws CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(0);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    parkingLots.park(REGISTRATION_NUMBER);
  }


  @Test (expected = ParkingLotFullException.class)
  public void testCannotParkIfParkingLotsIsFull() throws CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(2);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    for (int i = 0; i < 5; i++) {
      parkingLots.park(REGISTRATION_NUMBER+":"+i);
    }
  }

  @Test(expected = CarParkException.class)
  public void testSameCarCannotBeParkedTwice() throws CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(2);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.park(REGISTRATION_NUMBER);
  }

  @Test(expected = ParkingLotFullException.class)
  public void testSameCarCanNotBeParkedTwiceEvenWhenParkingLotsIsFull() throws CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(1);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.park(REGISTRATION_NUMBER);
  }

  @Test
  public void testRetriveParkedCar() throws CarRetrievalException, CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(1);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    String parkedCar = REGISTRATION_NUMBER;
    Token token = parkingLots.park(parkedCar);
    String retrievedCar = parkingLots.retrieve(token);
    assertThat(retrievedCar, is(parkedCar));
  }

  @Test(expected = CarRetrievalException.class)
  public void testCannotRetrieveUsingTheSameToken() throws CarRetrievalException, CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(1);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    Token token = parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.retrieve(token);
    parkingLots.retrieve(token);
  }

  @Test
  public void testCanParkAfterACarIsRetrievedFromAFullParkingLots() throws CarParkException, CarRetrievalException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(1);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    Token token = parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.retrieve(token);
    assertNotNull(parkingLots.park(REGISTRATION_NUMBER));
  }

  @Test(expected = CarRetrievalException.class)
  public void testCannotRetrieveUsingInvalidToken() throws CarRetrievalException, CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(1);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.retrieve(new Token());
  }

  //Multiple lots


  @Test(expected = ParkingLotFullException.class)
  public void testCannotParkIfParkingLotsHasZeroCapacityForMultipleParkingLots() throws CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(0,0);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    parkingLots.park(REGISTRATION_NUMBER);
  }


  @Test (expected = ParkingLotFullException.class)
  public void testCannotParkIfParkingLotsIsFullForMultipleParkingLots() throws CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(2,1);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.park(REGISTRATION_NUMBER+1);
    parkingLots.park(REGISTRATION_NUMBER+2);
    parkingLots.park(REGISTRATION_NUMBER+3);
  }

  @Test(expected = CarParkException.class)
  public void testSameCarCannotBeParkedTwiceForMultipleParkingLots() throws CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(3,1);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.park(REGISTRATION_NUMBER);
  }

  @Test(expected = ParkingLotFullException.class)
  public void testSameCarCanNotBeParkedTwiceEvenWhenParkingLotsIsFullForMultipleParkingLots() throws CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(1,1);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.park(REGISTRATION_NUMBER+1);
    parkingLots.park(REGISTRATION_NUMBER+2);
  }

  @Test
  public void testRetriveParkedCarForMultipleParkingLots() throws CarRetrievalException, CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(1,1);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    String parkedCar = REGISTRATION_NUMBER;
    Token token = parkingLots.park(parkedCar);
    String retrievedCar = parkingLots.retrieve(token);
    assertThat(retrievedCar, is(parkedCar));
  }

  @Test(expected = CarRetrievalException.class)
  public void testCannotRetrieveUsingTheSameTokenForMultipleParkingLots() throws CarRetrievalException, CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(1,5);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    Token token = parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.retrieve(token);
    parkingLots.retrieve(token);
  }

  @Test
  public void testCanParkAfterACarIsRetrievedFromAFullParkingLotsForMultipleParkingLots() throws CarParkException, CarRetrievalException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(1,1);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    Token token = parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.retrieve(token);
    assertNotNull(parkingLots.park(REGISTRATION_NUMBER));
  }

  @Test(expected = CarRetrievalException.class)
  public void testCannotRetrieveUsingInvalidTokenForMultipleParkingLots() throws CarRetrievalException, CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(1,1);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.retrieve(new Token());
  }

  @Test
  public void shouldParkInFreeParkingLot() throws CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = getParkingLotsForStrategyTesting(new FreeParkingLotStrategy());
    assertThat(parkingLotsList.get(0).getParkingOccupancy(), is(100.00d));
    assertThat(parkingLotsList.get(1).getParkingOccupancy(), is(0.00d));
  }

  @Test
  public void shouldParkInLeastOccupiedParkingLot() throws CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = getParkingLotsForStrategyTesting(new LeastOccupiedParkingLotStrategy());
    assertThat(parkingLotsList.get(0).getParkingOccupancy(), is(50.00d));
    assertThat(parkingLotsList.get(1).getParkingOccupancy(), is(50.00d));
  }

  @Test
  public void shouldParkInMostOccupiedButAvailableParkingLot() throws CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = getParkingLotsForStrategyTesting(new MostOccupiedParkingLotStrategy());
    assertThat(parkingLotsList.get(0).getParkingOccupancy(), is(100.00d));
    assertThat(parkingLotsList.get(1).getParkingOccupancy(), is(0.00d));
  }

  //Utility methods ahead
  private HashMap<Integer, ParkingLot> createParkingLots(int... arguments) {
    HashMap<Integer, ParkingLot> parkingLots = new HashMap<>();

    for (int i = 0; i < arguments.length; i++) {
      parkingLots.put(i, new ParkingLot(i, arguments[i]));
    }

    return parkingLots;
  }

  private HashMap<Integer, ParkingLot> getParkingLotsForStrategyTesting(ParkingStrategy strategy) throws CarParkException, ParkingLotFullException {
    HashMap<Integer, ParkingLot> parkingLotsList = createParkingLots(2,2);
    ParkingLots parkingLots = new ParkingLots(parkingLotsList);
    parkingLots.setParkingStrategy(strategy);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.park(REGISTRATION_NUMBER+1);
    return parkingLotsList;
  }
}
