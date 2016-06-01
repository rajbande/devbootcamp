package com.thoughtworks.devbootcamp.chemical;

public class Process implements ProcessBase{

  private final String name;
  private final Machine machineType;
  private int hours;

  public Process(String name, Machine machineType, int hours) {

    this.name = name;
    this.machineType = machineType;
    this.hours = hours;
  }

  @Override
  public String name() {
    return name();
  }

  public int getHours() {
    return hours;
  }

  @Override
  public Machine processingStage() {
    return machineType;
  }

  public void decrementTime() {
    hours--;
  }
}
