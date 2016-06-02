package com.thoughtworks.devbootcamp.chemicalfactory;

public class Chemical {
  private int[] hours;

  public Chemical(int... hours) throws Exception {
    if(hours.length < Machine.values().length) {
      throw new Exception("Invalid number of arguments");
    }

    this.hours = hours;
  }

  public boolean isComplete() {
    return hours[hours.length-1] <= 0;
  }

  public boolean shouldProcess(Machine machine) {
    int ordinal = machine.ordinal();
    if(ordinal == 0) {
      return hours[ordinal] > 0;
    } else {
      return hours[ordinal] > 0 && hours[(ordinal-1)] <= 0;
    }
  }

  public void process(Machine machine) {
    hours[machine.ordinal()]--;
  }
}
