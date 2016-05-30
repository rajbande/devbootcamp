package com.thoghtworks.shapes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RectangleTest {

  @Test
  public void testRectangleArea() {
    Rectangle rectangle = new Rectangle(2, 3);
    double area = rectangle.getArea();
    assertThat(area, is(6.0));
  }

  @Test(expected=RuntimeException.class)
  public void shouldNotCreateRectangleWithInvalidDimensions() {
    Rectangle rectangle = new Rectangle(-3.0, 2.0);
    double area = rectangle.getArea();
  }
}