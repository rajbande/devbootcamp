package com.thoughtworks.devbootcamp.probability;

public class Probability {
  public static final int MAX_PROBABILITY = 1;
  private double value;

  public Probability(double value) {
    this.value = value;
  }

  public Probability negate() {
    return new Probability(MAX_PROBABILITY - value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Probability that = (Probability) o;

    return Double.compare(that.value, value) == 0;

  }

  @Override
  public int hashCode() {
    long temp = Double.doubleToLongBits(value);
    return (int) (temp ^ (temp >>> 32));
  }
}
