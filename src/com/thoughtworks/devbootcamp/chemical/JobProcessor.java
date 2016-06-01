package com.thoughtworks.devbootcamp.chemical;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

import static com.thoughtworks.devbootcamp.chemical.Machine.*;

public class JobProcessor {
  private static JobProcessor jobProcessor;
  private final Timer timer;
  private final TimerTask task;
  private long tickCount = 0;
  private Queue<Chemical> jobsQ;
  private int productionHours;
  private List<Machine> grinders;
  private List<Machine> mixers;
  private List<Machine> reactors;
  private List<Machine> coolers;
  private List<Machine> packagers;
  private List<Machine> allMachines;

  private JobProcessor() {
    jobsQ = new LinkedList<>();

    startMachines();

    allMachines = new ArrayList<>();
    allMachines.addAll(grinders);
    allMachines.addAll(mixers);
    allMachines.addAll(reactors);
    allMachines.addAll(coolers);
    allMachines.addAll(packagers);


    timer = new Timer();
    task = new TimerTask() {
      @Override
      public void run() {
        tickCount++;
        execute();
      }
    };
  }

  private void startMachines() {
    grinders = new ArrayList<>(2);
    grinders.add(GRINDER);
    grinders.add(GRINDER);

    mixers = new ArrayList<>(2);
    mixers.add(MIXER);
    mixers.add(MIXER);

    reactors = new ArrayList<>(1);
    reactors.add(REACTOR);

    coolers = new ArrayList<>();
    coolers.add(COOLER);

    packagers = new ArrayList<>(1);
    packagers.add(PACKAGER);
  }

  public static JobProcessor getInstance() {
    if (jobProcessor == null) {
      jobProcessor = new JobProcessor();
    }

    return jobProcessor;
  }

  public void addJobs(Chemical... chemicals) {
    for (int i = 0; i < chemicals.length; i++) {
      jobsQ.add(chemicals[i]);
    }
    timer.scheduleAtFixedRate(task, 0, 1000);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("JobProcessor{");
    for (Chemical chemical : jobsQ) {
      builder.append(chemical.toString() + ",");
    }
    builder.append("}");
    return builder.toString();
  }

  public void execute() {
    while (!jobsQ.isEmpty()) {
      Chemical chemical = jobsQ.poll();
      chemical.setStartTickCount(tickCount);
      processChemical(chemical);
    }

    checkFreeMachines();
  }

  private void checkFreeMachines() {
    for (int i = 0; i < allMachines.size(); i++) {
      Machine machine = allMachines.get(i);
      machine.isFree(tickCount);
    }
  }

  private void processChemical(Chemical chemical) {
    switch(chemical.processingStage()) {
      case GRINDER:
        processChemical(chemical.getCurrentProcess(), grinders);
        break;
      case MIXER:
        processChemical(chemical.getCurrentProcess(), mixers);
        break;
      case REACTOR:
        processChemical(chemical.getCurrentProcess(), reactors);
        break;
      case COOLER:
        processChemical(chemical.getCurrentProcess(), coolers);
        break;
      case PACKAGER:
        processChemical(chemical.getCurrentProcess(), packagers);
        break;
    }
  }

  private void processChemical(Process process, List<Machine> machines) {
    for (int i = 0; i < machines.size(); i++) {
      Machine machine = machines.get(i);
      if(machine.isFree(tickCount)) {
        machine.process(process, tickCount);
      } else {
        incrementProductionHours(machine.getProcessedTime());
      }
    }
  }

  public void incrementProductionHours(int time) {
    productionHours += time;
  }

  public int getProductionHours() {
    return productionHours;
  }
}

