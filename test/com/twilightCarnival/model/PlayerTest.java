package com.twilightCarnival.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
  public static Player player;
  @BeforeClass
  public static void beforeClass(){
    player = new Player();
  }

  @Test
  public void testHasMap() {
    assertFalse(player.hasMap());
  }

  @Test
  public void testNumberOfKeys() {
    int expected = 1;
    int actual = player.getInventory().size();
    assertEquals(expected,actual);
  }

  @Test
  public void testGetInventory() {
    int expected = 1;
    int actual = player.getInventory().size();
    assertEquals(expected,actual);
  }

  @Test
  public void testSetInventory() {
    player.setInventory("Key1");
  }

  @Test
  public void testDisplayInventory() {
    player.setInventory("Key1");
    String expected = "Key1";
    String actual = player.displayInventory();
    assertEquals(expected,actual);

  }
  @Test
  public void testGetToken() {
    int expected = 3;
    int actual = player.getToken();
    assertEquals(expected,actual);
  }

  @Test
  public void testSetToken() {
    player.setToken(2);
    int expected = 2;
    int actual = player.getToken();
    assertEquals(expected,actual);
  }

  @Test
  public void testGetCurrentLocation() {
    String expected = "Moon";
    String actual = player.getCurrentLocation();
    assertEquals(expected,actual);
  }

  @Test
  public void testSetCurrentLocation() {
    player.setCurrentLocation("Moon");
    String expected = "Moon";
    String actual = player.getCurrentLocation();
    assertEquals(expected,actual);
  }
}