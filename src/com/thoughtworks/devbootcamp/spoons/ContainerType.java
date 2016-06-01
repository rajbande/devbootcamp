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

  public float convert(int thisQuantity, ContainerType thatSpoonType){
    return (float)(thisQuantity * this.conversionFactor)/thatSpoonType.conversionFactor;
  }

  public boolean isEqual(int quantity1, int quantity2, ContainerType thatSpoonType){
    return this.conversionFactor*quantity1 == quantity2*thatSpoonType.conversionFactor;

  }
  public float getFactor(ContainerType thatSpoonType){
    return this.conversionFactor/thatSpoonType.conversionFactor;

  }
}
