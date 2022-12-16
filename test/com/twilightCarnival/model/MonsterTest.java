package com.twilightCarnival.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MonsterTest {
  public static Monster monster;

  @BeforeClass
  public static void beforeClass() throws Exception {
    monster = new Monster("Balloon Dog Monster", "needle", "You carried by other balloon monsters", "You defeated the monster!","gold key");
  }

  @Test
  public void setStatus() {
    assertTrue(monster.isAlive());
    monster.setStatus(false);
    assertFalse(monster.isAlive());
  }

  @Test
  public void getName() {
    assertTrue("Balloon Dog Monster".equals(monster.getName()));
  }

  @Test
  public void isAlive() {
    assertFalse(monster.isAlive());
    monster.setStatus(true);
    assertTrue(monster.isAlive());
    ;
  }

  @Test
  public void getWeakness() {
    assertTrue("needle".equals(monster.getWeakness()));
  }

  @Test
  public void getKey() {
    assertTrue("gold key".equals(monster.getKey()));
  }

  @Test
  public void setKey() {
    monster.setKey(null);
    assertNull(monster.getKey());
  }

  @Test
  public void getWinMessage() {
    assertTrue("You defeated the monster!".equals(monster.getWinMessage()));
  }

  @Test
  public void getLostMessage() {
    assertTrue("You carried by other balloon monsters".equals(monster.getLostMessage()));
  }
}