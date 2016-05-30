package com.thoughtworks.devbootcamp.shapes;

import com.thoughtworks.devbootcamp.exceptions.InvalidDimensionsException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RectangleTest {

  @Test
  public void testRectangleArea() throws InvalidDimensionsException {
    Rectangle rectangle = new Rectangle(2, 3);
    double area = rectangle.area();
    assertThat(area, is(6.0));
  }

  @Test(expected = InvalidDimensionsException.class)
  public void shouldNotCreateRectangleWithInvalidDimensions() throws InvalidDimensionsException {
    new Rectangle(-3.0, 2.0);
  }
}