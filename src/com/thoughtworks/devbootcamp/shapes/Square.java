package com.thoughtworks.devbootcamp.shapes;

import com.thoughtworks.devbootcamp.exceptions.InvalidDimensionsException;
import com.thoughtworks.devbootcamp.util.Validator;

/**
 * Creates a {@code Square} with the given side.
 */
public class Square implements Shape {
  private final double side;

  public Square(double side) throws InvalidDimensionsException {
    this.side = side;

    if(Validator.isInvalid(side)) {
      throw new InvalidDimensionsException("Side cannot be negative");
    }
  }

  @Override
  public double area() {
    return Math.pow(side, 2);
  }
}
