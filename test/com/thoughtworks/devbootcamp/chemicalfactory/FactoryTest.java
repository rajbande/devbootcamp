package com.thoughtworks.devbootcamp.chemicalfactory;

import org.junit.Test;

import static com.thoughtworks.devbootcamp.chemicalfactory.Machine.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FactoryTest {

    @Test
    public void testTwoXs() throws Exception {
        Chemical chemicalX1 = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalX2 = new Chemical(3, 3, 1, 2, 1);

        ChemicalFactory chemicalFactory = new ChemicalFactory();

        assertThat(chemicalFactory.getProductionTime(chemicalX1, chemicalX2), is(13));
    }

    @Test
    public void testXandY() throws Exception {
        Chemical chemicalX = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalY = new Chemical(1, 1, 2, 2, 1);

        ChemicalFactory chemicalFactory = new ChemicalFactory();

        assertThat(chemicalFactory.getProductionTime(chemicalX, chemicalY), is(12));
    }

    @Test
    public void testTwoXsandZ() throws Exception {
        Chemical chemicalX1 = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalX2 = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalZ = new Chemical(3, 3, 3, 1, 1);

        ChemicalFactory chemicalFactory = new ChemicalFactory();
        assertThat(chemicalFactory.getProductionTime(chemicalX1, chemicalX2, chemicalZ), is(17));
    }

    @Test
    public void testThreeYsAndXAndZ() throws Exception {
        Chemical chemicalY1 = new Chemical(1, 1, 2, 2, 1);
        Chemical chemicalY2 = new Chemical(1, 1, 2, 2, 1);
        Chemical chemicalY3 = new Chemical(1, 1, 2, 2, 1);
        Chemical chemicalX = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalZ = new Chemical(3, 3, 3, 1, 1);

        ChemicalFactory chemicalFactory = new ChemicalFactory();

        assertThat(chemicalFactory.getProductionTime(chemicalY1, chemicalY2, chemicalY3, chemicalX, chemicalZ), is(17));
    }

    @Test
    public void testGrinding() throws Exception {
        Chemical chemX = new Chemical(3, 3, 1, 2, 1);

        assertTrue(chemX.shouldProcess(GRINDER));
        chemX.process(GRINDER);
    }
}
