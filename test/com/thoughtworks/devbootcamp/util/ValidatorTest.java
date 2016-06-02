package com.thoughtworks.devbootcamp.util;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidatorTest {

  @Test
  public void testIsInvalid() throws Exception {
    assertThat(Validator.isInvalid(8.0), is(false));
    assertThat(Validator.isInvalid(-7.0), is(true));
    assertThat(Validator.isInvalid(8.0, 0, -7.0), is(true));
  }
}