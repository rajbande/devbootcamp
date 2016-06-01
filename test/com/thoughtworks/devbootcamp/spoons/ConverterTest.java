package com.thoughtworks.devbootcamp.spoons;

import org.junit.Test;

import static com.thoughtworks.devbootcamp.spoons.ContainerType.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ConverterTest {

  @Test
  public void testConvert() throws Exception {
    assertTrue(Ounce.to(8, Cup) == 1);
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
    assertTrue(Gallon.conversionFactor(ContainerType.Quart)==4);
    assertTrue(ContainerType.Quart.conversionFactor(Cup)==4);
  }

  @Test
  public void testThreePlusSixIsNineTeaSpoons() {
    float threePlusSixTeaspoons = Teaspoon.to(3, Teaspoon) + Teaspoon.to(6, Teaspoon);
    assertThat(threePlusSixTeaspoons, is(9.0f));
  }

  @Test
  public void testThreePlusSixTeaSpoonsEqualsThreeTableSpoons() {
    float threePlusSixTeaspoons = Teaspoon.to(3, Teaspoon) + Teaspoon.to(6, Teaspoon);
    assertThat(threePlusSixTeaspoons, is(TableSpoon.to(3, Teaspoon)));
  }

  @Test
  public void testOnePintPlusTwoCupsEqualsOneNinetyTwoTeaSpoons() {
    float threePlusSixTeaspoons = Pint.to(1, Teaspoon) + Cup.to(2, Teaspoon);
    assertThat(threePlusSixTeaspoons, is(Teaspoon.to(192, Teaspoon)));
  }

  @Test
  public void testOnePintPlusTwoCupsEqualsSixtyFourTableSpoons() {
    float threePlusSixTeaspoons = Pint.to(1, Teaspoon) + Cup.to(2, Teaspoon);
    assertThat(threePlusSixTeaspoons, is(TableSpoon.to(64, Teaspoon)));
  }

  @Test
  public void testOnePintPlusTwoCupsDoesNotEqualFiveTeaSpoons() {
    float threePlusSixTeaspoons = Pint.to(1, Teaspoon) + Cup.to(2, Teaspoon);
    assertThat(threePlusSixTeaspoons, not(Teaspoon.to(5, Teaspoon)));
  }
}
