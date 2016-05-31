package com.thoughtworks.devbootcamp.spoons;

public class TeaSpoon {
  private final int teaSpoonQuantity = 1;

  public TeaSpoon() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TeaSpoon teaSpoon = (TeaSpoon) o;

    return teaSpoonQuantity == teaSpoon.teaSpoonQuantity;

  }

  @Override
  public int hashCode() {
    return teaSpoonQuantity;
  }
}
