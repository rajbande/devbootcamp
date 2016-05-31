package com.thoughtworks.devbootcamp.spoons;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TeaSpoonTest {
  @Test
  public void testTeaSpoonsEquality() {
    TeaSpoon firstTeaSpoon = new TeaSpoon();
    TeaSpoon secondTeaSpoon = new TeaSpoon();

    assertTrue(firstTeaSpoon.equals(secondTeaSpoon));
  }
}
