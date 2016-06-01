package com.thoughtworks.devbootcamp.chemical;

public enum Machine {
  GRINDER,
  MIXER,
  REACTOR,
  COOLER,
  PACKAGER;

  private Process process;
  private long startTickCount;
  private boolean free;

  public void process(Process process, long startTickCount) {
    this.process = process;
    if(startTickCount == 0) {
      this.startTickCount = startTickCount;
    } else {
      decrementTime(process);
    }
    free = false;
  }

  private void decrementTime(Process process) {
    process.decrementTime();
    if(process.getHours() == 0){

    }
  }

  public boolean isFree(long tickCount) {
    if (hasFinished(tickCount)){
      free = true;
      return free;
    }

    return free;
  }

  public void setFree(boolean free) {
    this.free = free;
  }

  private boolean hasFinished(long tickCount) {
    int subtraction = (int) (tickCount - startTickCount);
    if(process == null){
      return true;
    }
    if(subtraction == process.getHours()) {
      return true;
    }
    return false;
  }

  public int getProcessedTime() {
    if (process == null) {
      return 0;
    }
    return process.getHours();
  }
}
