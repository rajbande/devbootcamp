package com.thoughtworks.devbootcamp.spoons;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TableSpoonTest {
  @Test
  public void testTableSpoonsEquality() {
    TableSpoon firstTableSpoon = new TableSpoon();
    TableSpoon secondTableSpoon = new TableSpoon();

    assertTrue(firstTableSpoon.equals(secondTableSpoon));
  }

  @Test
  public void testOneTableSpoonEqualsThreeTeaSpoons() {
    TableSpoon tableSpoon = new TableSpoon();
    assertTrue(tableSpoon.isTeaSpoonQuantity(3));
  }

  @Test
  public void testThreeTeaSpoonsEqualsOneTableSpoon() {
    List<TeaSpoon> teaSpoons = new ArrayList<>();
    teaSpoons.add(new TeaSpoon());
    teaSpoons.add(new TeaSpoon());
    teaSpoons.add(new TeaSpoon());

    TableSpoon tableSpoon = new TableSpoon();
    assertTrue(tableSpoon.isTeaSpoonQuantity(teaSpoons.size()));
  }
}
