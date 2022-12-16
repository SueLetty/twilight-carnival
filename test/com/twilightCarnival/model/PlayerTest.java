package com.twilightCarnival.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
  public static Player player;
  @BeforeClass
  public static void beforeClass() throws Exception {
    player = new Player();
  }

  @Test
  public void hasMap() {
    assertFalse(player.hasMap());
  }

  @Test
  public void numberOfKeys() {
    assertEquals(1,player.getInventory().size());
  }

  @Test
  public void getInventory() {
    assertEquals(0,player.getInventory().size());
  }

  @Test
  public void setInventory() {
    player.setInventory("Key1");
  }

  @Test
  public void displayInventory() {
    String result = "Key1";
    assertEquals(result,player.displayInventory());

  }
  @Test
  public void getToken() {
    assertEquals(2,player.getToken());
  }

  @Test
  public void setToken() {
    player.setToken(2);
    assertEquals(2,player.getToken());
  }

  @Test
  public void getCurrentLocation() {
    assertEquals("Ball Pit", player.getCurrentLocation());
  }

  @Test
  public void setCurrentLocation() {
    player.setCurrentLocation("Moon");
    assertTrue("Moon".equals(player.getCurrentLocation()));
  }
}