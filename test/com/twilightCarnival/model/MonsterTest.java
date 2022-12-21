package com.twilightCarnival.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class MonsterTest {

  public static Monster monster;

  @BeforeClass
  public static void beforeClass() {
    monster = new Monster("Balloon Dog Monster", "needle", "You carried by other balloon monsters",
        "You defeated the monster!", "gold key");
  }

  @Test
  public void testSetStatus() {
    assertTrue(monster.isAlive());
    monster.setStatus(false);
    assertFalse(monster.isAlive());
  }

  @Test
  public void testGetName() {
    String expected = "Balloon Dog Monster";
    String actual = monster.getName();
    assertEquals(expected, actual);
  }

  @Test
  public void isAlive() {
    assertFalse(monster.isAlive());
    monster.setStatus(true);
    assertTrue(monster.isAlive());

  }

  @Test
  public void testGetWeakness() {
    String expected = "needle";
    String actual = monster.getWeakness();
    assertEquals(expected, actual);
  }

  @Test
  public void testGetKey() {
    String expected = "gold key";
    String actual = monster.getKey();
    assertEquals(expected, actual);
  }

  @Test
  public void testSetKey() {
    monster.setKey(null);
    assertNull(monster.getKey());
  }

  @Test
  public void testGetWinMessage() {
    String expected = "You defeated the monster!";
    String actual = monster.getWinMessage();
    assertEquals(expected, actual);
  }

  @Test
  public void testGetLostMessage() {
    String expected = "You carried by other balloon monsters";
    String actual = monster.getLostMessage();
    assertEquals(expected, actual);
  }
}