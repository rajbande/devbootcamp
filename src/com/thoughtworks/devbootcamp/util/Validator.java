package com.thoughtworks.devbootcamp.util;

public class Validator {
  public static boolean isInvalid(double... dimensions) {
    for (int i = 0; i < dimensions.length; i++) {
      if (dimensions[i] < 0) {
        return true;
      }
    }
    return false;
  }
}
