package com.thoghtworks.shapes;

public class Rectangle {
  private final double length;
  private final double breadth;

  public Rectangle(double length, double breadth) {
    this.length = length;
    this.breadth = breadth;

    if(isInvalid(length, breadth)) {
      throw new RuntimeException("Negative values are not allowed");
    }
  }

  private boolean isInvalid(double length, double breadth) {
    return length < 0 || breadth < 0;
  }

  public double getArea() {
    return length * breadth;
  }
}
