package com.thoughtworks.devbootcamp.spoons;

public class TableSpoon {
  private final int tableSpoonQuantity = 1;
  private final int teaSpoonsQuantity = 3;

  public TableSpoon() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TableSpoon that = (TableSpoon) o;

    if (tableSpoonQuantity != that.tableSpoonQuantity) return false;
    return teaSpoonsQuantity == that.teaSpoonsQuantity;

  }

  @Override
  public int hashCode() {
    int result = tableSpoonQuantity;
    result = 31 * result + teaSpoonsQuantity;
    return result;
  }

  public boolean isTeaSpoonQuantity(int expectedTeaSpoonQuantity) {
    return expectedTeaSpoonQuantity == teaSpoonsQuantity;
  }
}
