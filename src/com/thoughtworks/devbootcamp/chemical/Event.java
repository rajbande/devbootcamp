package com.thoughtworks.devbootcamp.chemical;

public interface Event {
  public void onGrindingFinished(Chemical chemical);
  public void onMixingFinished(Chemical chemical);
  public void onReactionFinished(Chemical chemical);
  public void onCoolingFinished(Chemical chemical);
  public void onPackagingFinished(Chemical chemical);
  public void jobComplete(Chemical chemical);
}
