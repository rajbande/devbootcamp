package com.thoghtworks.devbootcamp.shapes;

import com.thoghtworks.devbootcamp.exceptions.InvalidDimensionsException;
import com.thoghtworks.devbootcamp.util.Validator;

/**
 * Creates a {@code Rectangle} with given length and breadth.
 */
public class Rectangle implements Shape {
  private final double length;
  private final double breadth;

  public Rectangle(double length, double breadth) throws InvalidDimensionsException {
    this.length = length;
    this.breadth = breadth;

    if(Validator.isInvalid(length, breadth)) {
      throw new InvalidDimensionsException("Negative values are not allowed");
    }
  }

  @Override
  public double area() {
    return length * breadth;
  }
}
