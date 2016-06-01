package com.thoughtworks.devbootcamp.spoons;

public enum ContainerType {
  Teaspoon(1),
  TableSpoon(3),
  Ounce(6),
  Cup(48),
  Pint(96),
  Quart(192),
  Gallon(768);

  private final int conversionFactor;

  ContainerType(int conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public float to(int times, ContainerType thatSpoonType){
    return (float)(times * this.conversionFactor)/thatSpoonType.conversionFactor;
  }

  public boolean isEqual(int times, int thatTypeTimes, ContainerType thatSpoonType){
    return this.conversionFactor * times == thatTypeTimes*thatSpoonType.conversionFactor;
  }

  public float conversionFactor(ContainerType thatSpoonType){
    return this.conversionFactor/thatSpoonType.conversionFactor;
  }
}
