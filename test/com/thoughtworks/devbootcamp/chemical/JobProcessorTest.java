package com.thoughtworks.devbootcamp.chemical;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobProcessorTest {

  private JobProcessor jobProcessor;
  private Chemical chemicalX;
  private Chemical chemicalX1;
  private Chemical chemicalX2;

  @Before
  public void setUp() {
    jobProcessor = JobProcessor.getInstance();
    chemicalX = new Chemical("X", 3, 3, 1, 2, 1);
//    chemicalX = new Chemical("X", 3);
  }

  @Test
  public void testProductionTime() {
    jobProcessor.addJobs(chemicalX);
    assertThat(jobProcessor.getProductionHours(), is(10));
  }
}
