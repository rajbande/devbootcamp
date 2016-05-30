package com.thoughtworks.devbootcamp.probability;

import org.junit.Test;
import org.w3c.dom.Document;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ProbabilityTest {
  @Test
  public void testNegation() {
    Probability probability = new Probability(0.4);
    Probability negation = new Probability(0.6);
    assertThat(probability.negate(), is(negation));
  }

  @Test
  public void testEqualsReflexive(){
    Probability probability = new Probability(0.4);
    assertTrue(probability.equals(probability));
  }

  @Test
  public void testEqualsSymmetric(){
    Probability probability1 = new Probability(0.4);
    Probability probability2 = new Probability(0.4);
    assertTrue(probability1.equals(probability2));
  }

  @Test
  public void testEqualsTransitive() {
    Probability probability1 = new Probability(0.4);
    Probability probability2 = new Probability(0.4);
    Probability probability3 = new Probability(0.4);

    assertTrue(probability1.equals(probability2));
    assertTrue(probability2.equals(probability3));
    assertTrue(probability1.equals(probability3));
  }

  @Test
  public void testIncompatibleObjects() {
    Probability probability = new Probability(0.4);
    Double dbl = Double.valueOf(0.4);

    assertFalse(probability.equals(dbl));
  }
}
