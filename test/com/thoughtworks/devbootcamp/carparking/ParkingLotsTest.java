package com.thoughtworks.devbootcamp.carparking;

import com.thoughtworks.devbootcamp.carparking.exceptions.CarParkException;
import com.thoughtworks.devbootcamp.carparking.exceptions.CarRetrievalException;
import com.thoughtworks.devbootcamp.carparking.exceptions.ParkingLotFullException;
import com.thoughtworks.devbootcamp.carparking.models.Token;
import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ParkingLotsTest {
  private static final String REGISTRATION_NUMBER = "MH 12 KB 1055";

  @Test
  public void shouldCreateParkingLotsWithGivenCapacities() {
    ParkingLots parkingLots = new ParkingLots(1, 3);
    assertThat(parkingLots.getParkingLotCount(), is(2));
  }

  @Test
  public void testParkingSuccessful() throws CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(1);
    assertNotNull(parkingLots.park(REGISTRATION_NUMBER));
  }

  @Test(expected = ParkingLotFullException.class)
  public void testCannotParkIfParkingLotsHasZeroCapacity() throws CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(0);
    parkingLots.park(REGISTRATION_NUMBER);
  }


  @Test (expected = ParkingLotFullException.class)
  public void testCannotParkIfParkingLotsIsFull() throws CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(2);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.park(REGISTRATION_NUMBER+1);
    parkingLots.park(REGISTRATION_NUMBER+2);
  }

  @Test(expected = CarParkException.class)
  public void testSameCarCannotBeParkedTwice() throws CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(3);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.park(REGISTRATION_NUMBER);
  }

  @Test(expected = ParkingLotFullException.class)
  public void testSameCarCanNotBeParkedTwiceEvenWhenParkingLotsIsFull() throws CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(1);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.park(REGISTRATION_NUMBER);
  }

  @Test
  public void testRetriveParkedCar() throws CarRetrievalException, CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(1);
    String parkedCar = REGISTRATION_NUMBER;
    Token token = parkingLots.park(parkedCar);
    String retrievedCar = parkingLots.retrieve(token);
    assertThat(retrievedCar, is(parkedCar));
  }

  @Test(expected = CarRetrievalException.class)
  public void testCannotRetrieveUsingTheSameToken() throws CarRetrievalException, CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(1);
    Token token = parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.retrieve(token);
    parkingLots.retrieve(token);
  }

  @Test
  public void testCanParkAfterACarIsRetrievedFromAFullParkingLots() throws CarParkException, CarRetrievalException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(1);
    Token token = parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.retrieve(token);
    assertNotNull(parkingLots.park(REGISTRATION_NUMBER));
  }

  @Test(expected = CarRetrievalException.class)
  public void testCannotRetrieveUsingInvalidToken() throws CarRetrievalException, CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(1);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.retrieve(new Token());
  }

  //Multiple lots


  @Test(expected = ParkingLotFullException.class)
  public void testCannotParkIfParkingLotsHasZeroCapacityForMultipleParkingLots() throws CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(0, 0);
    parkingLots.park(REGISTRATION_NUMBER);
  }


  @Test (expected = ParkingLotFullException.class)
  public void testCannotParkIfParkingLotsIsFullForMultipleParkingLots() throws CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(2, 1);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.park(REGISTRATION_NUMBER+1);
    parkingLots.park(REGISTRATION_NUMBER+2);
    parkingLots.park(REGISTRATION_NUMBER+3);
  }

  @Test(expected = CarParkException.class)
  public void testSameCarCannotBeParkedTwiceForMultipleParkingLots() throws CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(3, 1);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.park(REGISTRATION_NUMBER);
  }

  @Test(expected = ParkingLotFullException.class)
  public void testSameCarCanNotBeParkedTwiceEvenWhenParkingLotsIsFullForMultipleParkingLots() throws CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(1, 1);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.park(REGISTRATION_NUMBER);
  }

  @Test
  public void testRetriveParkedCarForMultipleParkingLots() throws CarRetrievalException, CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(1, 1);
    String parkedCar = REGISTRATION_NUMBER;
    Token token = parkingLots.park(parkedCar);
    String retrievedCar = parkingLots.retrieve(token);
    assertThat(retrievedCar, is(parkedCar));
  }

  @Test(expected = CarRetrievalException.class)
  public void testCannotRetrieveUsingTheSameTokenForMultipleParkingLots() throws CarRetrievalException, CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(1, 5);
    Token token = parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.retrieve(token);
    parkingLots.retrieve(token);
  }

  @Test
  public void testCanParkAfterACarIsRetrievedFromAFullParkingLotsForMultipleParkingLots() throws CarParkException, CarRetrievalException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(1, 1);
    Token token = parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.retrieve(token);
    assertNotNull(parkingLots.park(REGISTRATION_NUMBER));
  }

  @Test(expected = CarRetrievalException.class)
  public void testCannotRetrieveUsingInvalidTokenForMultipleParkingLots() throws CarRetrievalException, CarParkException, ParkingLotFullException {
    ParkingLots parkingLots = new ParkingLots(1 , 1);
    parkingLots.park(REGISTRATION_NUMBER);
    parkingLots.retrieve(new Token());
  }



}
