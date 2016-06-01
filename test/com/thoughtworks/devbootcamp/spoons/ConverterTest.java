package com.thoughtworks.devbootcamp.spoons;

import org.junit.Test;

import static com.thoughtworks.devbootcamp.spoons.ContainerType.*;
import static org.junit.Assert.assertTrue;

public class ConverterTest {

  @Test
  public void testConvert() throws Exception {
    assertTrue(Ounce.convert(8, Cup) == 1);
  }


  @Test
  public void testQuantityEqual() throws Exception {
    assertTrue(Teaspoon.isEqual(3,3, Teaspoon));
    assertTrue(ContainerType.TableSpoon.isEqual(1,3, Teaspoon));
    assertTrue(Teaspoon.isEqual(3,1,ContainerType.TableSpoon));
    assertTrue(Teaspoon.isEqual(3,1,ContainerType.TableSpoon));
    assertTrue(Teaspoon.isEqual(3,1,ContainerType.TableSpoon));
    assertTrue(Cup.isEqual(1,8, Ounce));
    assertTrue(Ounce.isEqual(1,2,ContainerType.TableSpoon));
    assertTrue(Pint.isEqual(1,2, Cup));
    assertTrue(ContainerType.Quart.isEqual(1,4, Cup));
    assertTrue(Gallon.isEqual(1,4,ContainerType.Quart));


  }
  @Test
  public void testGetFactor() throws Exception {
    assertTrue(Gallon.getFactor(ContainerType.Quart)==4);
    assertTrue(ContainerType.Quart.getFactor(Cup)==4);
  }


}
