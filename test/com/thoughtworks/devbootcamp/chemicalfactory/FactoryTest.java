package com.thoughtworks.devbootcamp.chemicalfactory;

import com.thoughtworks.devbootcamp.factory.Chemical;
import com.thoughtworks.devbootcamp.factory.ChemicalFactory;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactoryTest {

    @Test
    public void testXX() throws Exception {
        Chemical chemicalX1 = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalX2 = new Chemical(3, 3, 1, 2, 1);

        com.thoughtworks.devbootcamp.factory.ChemicalFactory chemicalFactory = new com.thoughtworks.devbootcamp.factory.ChemicalFactory();

        assertThat(chemicalFactory.productionTime(chemicalX1, chemicalX2), is(13));
    }

    @Test
    public void testXY() throws Exception {
        Chemical chemicalX = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalY = new Chemical(1, 1, 2, 2, 1);

        com.thoughtworks.devbootcamp.factory.ChemicalFactory chemicalFactory = new com.thoughtworks.devbootcamp.factory.ChemicalFactory();

        assertThat(chemicalFactory.productionTime(chemicalX, chemicalY), is(12));
    }

    @Test
    public void testXXZ() throws Exception {
        Chemical chemicalX1 = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalX2 = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalZ = new Chemical(3, 3, 3, 1, 1);

        com.thoughtworks.devbootcamp.factory.ChemicalFactory chemicalFactory = new com.thoughtworks.devbootcamp.factory.ChemicalFactory();
        assertThat(chemicalFactory.productionTime(chemicalX1, chemicalX2, chemicalZ), is(17));
    }

    @Test
    public void testYYYXZ() throws Exception {
        Chemical chemicalX = new Chemical(3, 3, 1, 2, 1);
        Chemical chemicalY1 = new Chemical(1, 1, 2, 2, 1);
        Chemical chemicalY2 = new Chemical(1, 1, 2, 2, 1);
        Chemical chemicalY3 = new Chemical(1, 1, 2, 2, 1);
        Chemical chemicalZ = new Chemical(3, 3, 3, 1, 1);

        com.thoughtworks.devbootcamp.factory.ChemicalFactory chemicalFactory = new ChemicalFactory();

        assertThat(chemicalFactory.productionTime(chemicalY1, chemicalY2, chemicalY3, chemicalX, chemicalZ), is(17));
    }

    @Test
    public void testChemical() throws Exception {
        Chemical chemX = new Chemical(3, 3, 1, 2, 1);

        chemX.grind();
        assertTrue(chemX.shouldGrind());

        chemX.grind();
        assertTrue(chemX.shouldGrind());

        chemX.grind();
        assertFalse(chemX.shouldGrind());

        chemX.mix();
        assertTrue(chemX.shouldMix());

        chemX.mix();
        assertTrue(chemX.shouldMix());

        chemX.mix();
        assertFalse(chemX.shouldMix());

        chemX.react();
        assertFalse(chemX.shouldReact());

        chemX.cool();
        assertTrue(chemX.shouldCool());

        chemX.cool();
        assertFalse(chemX.shouldCool());

        chemX.pack();
        assertFalse(chemX.shouldPack());
    }
}
