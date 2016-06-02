package com.thoughtworks.devbootcamp.carparking;

import com.thoughtworks.devbootcamp.carparking.exceptions.CarParkException;
import com.thoughtworks.devbootcamp.carparking.exceptions.CarRetrievalException;
import com.thoughtworks.devbootcamp.carparking.exceptions.ParkingLotFullException;
import com.thoughtworks.devbootcamp.carparking.models.Token;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {


    public static final String CAR = "AX123345";

    @Test
    public void testParkingSuccessful() throws CarParkException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        assertNotNull(parkingLot.park("AX123345"));
    }

    @Test(expected = ParkingLotFullException.class)
    public void testCannotParkIfParkingLotHasZeroCapacity() throws CarParkException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, 0);
        parkingLot.park("AX123345");
    }

    @Test (expected = ParkingLotFullException.class)
    public void testCannotParkIfParkingLotIsFull() throws CarParkException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, 2);
        parkingLot.park("AX123345");
        parkingLot.park("1231233455757");
        parkingLot.park("MH 12 skfhk");
    }

    @Test(expected = CarParkException.class)
    public void testSameCarCannotBeParkedTwice() throws CarParkException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, 3);
        parkingLot.park("AX123345");
        parkingLot.park("AX123345");
    }

    @Test(expected = CarParkException.class)
    public void testSameCarCanNotBeParkedTwiceEvenWhenParkingLotIsFull() throws CarParkException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        parkingLot.park("AX123345");
        parkingLot.park("AX123345");
    }

    @Test
    public void testRetriveParkedCar() throws CarRetrievalException, CarParkException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        String parkedCar = "AX123345";
        Token token = parkingLot.park(parkedCar);
        String retrievedCar = parkingLot.retrieve(token);
        assertThat(retrievedCar, is(parkedCar));
    }

    @Test(expected = CarRetrievalException.class)
    public void testCannotRetrieveUsingTheSameToken() throws CarRetrievalException, CarParkException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        Token token = parkingLot.park(CAR);
        parkingLot.retrieve(token);
        parkingLot.retrieve(token);
    }

    @Test
    public void testCanParkAfterACarIsRetrievedFromAFullParkingLot() throws CarParkException, CarRetrievalException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        Token token = parkingLot.park(CAR);
        parkingLot.retrieve(token);
        assertNotNull(parkingLot.park(CAR));
    }

    @Test(expected = CarRetrievalException.class)
    public void testCannotRetrieveUsingInvalidToken() throws CarRetrievalException, CarParkException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        parkingLot.park(CAR);
        parkingLot.retrieve(new Token());
    }


}
