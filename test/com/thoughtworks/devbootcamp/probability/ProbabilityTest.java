package com.thoughtworks.devbootcamp.probability;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProbabilityTest {
  @Test
  public void testNegation() {
    Probability probability = new Probability(0.4);
    Probability negation = new Probability(0.6);
    assertThat(probability.negate(), is(negation));
  }

  @Test
  public void testDoubleNegation() {
    Probability probability = new Probability(0.3);
    Probability negation = new Probability(0.3);
    Probability negated = probability.negate();
    assertThat(negated.negate(), is(negation));
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

  @Test
  public void shouldAnd() {
    Probability probability1 = new Probability(0.4);
    Probability probability2 = new Probability(0.3);

    assertThat(probability1.and(probability2), is(new Probability(0.12)));
  }

  @Test
  public void shouldOr() {
    Probability probability1 = new Probability(0.4);
    Probability probability2 = new Probability(0.3);

    assertThat(probability1.or(probability2), is(new Probability(0.58)));
  }

  @Test
  public void shouldOrWithUpperBoundaryConditions() {
    Probability probability1 = new Probability(1.0);
    Probability probability2 = new Probability(1.0);

    assertThat(probability1.or(probability2), is(new Probability(1.0)));
  }

  @Test
  public void shouldOrWithLowerBoundaryConditions() {
    Probability probability1 = new Probability(0.0);
    Probability probability2 = new Probability(0.0);

    assertThat(probability1.or(probability2), is(new Probability(0.0)));
  }
}
