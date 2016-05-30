package com.thoughtworks.devbootcamp.probability;

public class Probability {
  public static final int MAX_PROBABILITY = 1;
  private double chance;

  public Probability(double chance) {
    this.chance = chance;
  }

  public Probability negate() {
    double negatedChance = MAX_PROBABILITY - chance;
    return new Probability(round(negatedChance));
  }

  private double round(double negatedChance) {
    return (Math.round(negatedChance * 10000))/10000.0;
  }

  public Probability and(Probability that) {
    return new Probability(this.chance * that.chance);
  }

  public Probability or(Probability that) {
    return new Probability(this.chance + that.chance);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Probability that = (Probability) o;

    return Double.compare(that.chance, chance) == 0;

  }

  @Override
  public int hashCode() {
    long temp = Double.doubleToLongBits(chance);
    return (int) (temp ^ (temp >>> 32));
  }
}
