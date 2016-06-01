package com.thoughtworks.devbootcamp.chemicalfactory;

import org.junit.Test;

import static com.thoughtworks.devbootcamp.chemicalfactory.Machine.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FactoryTest {

    @Test
    public void testXX() throws Exception {
        Chemical chemicalX1 = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalX2 = new Chemical(3, 3, 1, 2, 1);

        ChemicalFactory chemicalFactory = new ChemicalFactory();

        assertThat(chemicalFactory.getProductionTime(chemicalX1, chemicalX2), is(10));
    }

    @Test
    public void testXY() throws Exception {
        Chemical chemicalX = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalY = new Chemical(1, 1, 2, 2, 1);

        ChemicalFactory chemicalFactory = new ChemicalFactory();

        assertThat(chemicalFactory.getProductionTime(chemicalX, chemicalY), is(10));
    }

    @Test
    public void testXXZ() throws Exception {
        Chemical chemicalX1 = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalX2 = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalZ = new Chemical(3, 3, 3, 1, 1);

        ChemicalFactory chemicalFactory = new ChemicalFactory();
        assertThat(chemicalFactory.getProductionTime(chemicalX1, chemicalX2, chemicalZ), is(11));
    }
//
//    @Test
//    public void testYYYXZ() throws Exception {
//        Chemical chemicalY1 = new Chemical(1, 1, 2, 2, 1);
//        Chemical chemicalY2 = new Chemical(1, 1, 2, 2, 1);
//        Chemical chemicalY3 = new Chemical(1, 1, 2, 2, 1);
//        Chemical chemicalX = new Chemical(3, 3, 1, 2, 1);
//        Chemical chemicalZ = new Chemical(3, 3, 3, 1, 1);
//
//        ChemicalFactory chemicalFactory = new ChemicalFactory();
//
//        assertThat(chemicalFactory.getProductionTime(chemicalY1, chemicalY2, chemicalY3, chemicalX, chemicalZ), is(17));
//    }

    @Test
    public void testChemical() throws Exception {
        Chemical chemX = new Chemical(3, 3, 1, 2, 1);

        assertTrue(chemX.shouldProcess(GRINDER));
        chemX.process(GRINDER);

        assertTrue(chemX.shouldProcess(GRINDER));
        chemX.process(GRINDER);

        assertTrue(chemX.shouldProcess(GRINDER));
        chemX.process(GRINDER);

        assertTrue(chemX.shouldProcess(MIXER));
        chemX.process(MIXER);

        assertTrue(chemX.shouldProcess(MIXER));
        chemX.process(MIXER);

        assertTrue(chemX.shouldProcess(MIXER));
        chemX.process(MIXER);

        assertTrue(chemX.shouldProcess(REACTOR));
        chemX.process(REACTOR);

        assertTrue(chemX.shouldProcess(COOLER));
        chemX.process(COOLER);

        assertTrue(chemX.shouldProcess(COOLER));
        chemX.process(COOLER);

        assertTrue(chemX.shouldProcess(PACKAGER));
        chemX.process(PACKAGER);
    }
}
