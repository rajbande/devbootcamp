package com.thoughtworks.devbootcamp.shapes;

import com.thoughtworks.devbootcamp.exceptions.InvalidDimensionsException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
  @Test
  public void testArea() throws InvalidDimensionsException {
    Square square = new Square(2.0);
    double area = square.area();
    assertThat(area, is(4.0));
  }

  @Test(expected = InvalidDimensionsException.class)
  public void shouldNotCreateSquareWithInvalidDimensions() throws InvalidDimensionsException {
    new Square(-2.0);
  }
}