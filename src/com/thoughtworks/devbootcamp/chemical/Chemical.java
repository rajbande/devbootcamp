package com.thoughtworks.devbootcamp.chemical;

import java.util.ArrayList;

public class Chemical implements ProcessBase {

  private final String name;
  private final int grindingHours;
  private final int mixingHours;
  private final int reactingHours;
  private final int coolingHours;
  private final int packagingHours;
  private Machine processingState;
  private long startTickCount;
  private ArrayList<Process> processes;
  private Process curentProcess;

  public Chemical(String name, int grindingHours, int mixingHours, int reactingHours, int coolingHours, int packagingHours) {
    this.name = name;
    this.grindingHours = grindingHours;
    this.mixingHours = mixingHours;
    this.reactingHours = reactingHours;
    this.coolingHours = coolingHours;
    this.packagingHours = packagingHours;

    addProcesses(name, grindingHours, mixingHours, reactingHours, coolingHours, packagingHours);

    this.processingState = Machine.GRINDER;
  }

  private void addProcesses(String name, int grindingHours, int mixingHours, int reactingHours, int coolingHours, int packagingHours) {
    processes = new ArrayList<>();
    Process grinding = new Process(name, Machine.GRINDER, grindingHours);
    Process mixing = new Process(name, Machine.MIXER, mixingHours);
    Process reacting = new Process(name, Machine.REACTOR, reactingHours);
    Process cooling = new Process(name, Machine.COOLER, coolingHours);
    Process packaging = new Process(name, Machine.PACKAGER, packagingHours);
    processes.add(grinding);
    processes.add(mixing);
    processes.add(reacting);
    processes.add(cooling);
    processes.add(packaging);

    setCurentProcess(grinding);
  }

  @Override
  public String name() {
    return name;
  }

  public int getHours() {
    return grindingHours;
  }

  @Override
  public Machine processingStage() {
    return processingState;
  }

  @Override
  public String toString() {
    return name;
  }

  public void setStartTickCount(long startTickCount) {
    this.startTickCount = startTickCount;
  }

  public long getStartTickCount() {
    return startTickCount;
  }

  public Process getCurrentProcess() {
    return curentProcess;
  }

  public void setCurentProcess(Process curentProcess) {
    this.curentProcess = curentProcess;
  }
}
