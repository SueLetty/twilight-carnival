package com.twilightCarnival.model;

import static org.junit.Assert.*;

import java.util.HashMap;
import org.junit.BeforeClass;
import org.junit.Test;

public class StationTest {
  public static Station station;
  @BeforeClass
  public static void beforeClass(){
    String name = "Gift Shop";
    String[] villain = new String[]{"Balloon Dog Monster",
        "needle",
        "*lets out a continuous cry*. \nYou are quickly surrounded by other balloon animals and they grab you. \nYou start to float away never to be seen again. Game Over.",
        "Quickly you prick the Balloon Dog with a needle, and it drops a silver key.",
        "silver key"};
    String item = "Gold Key";
    String[] surroundings = new String[]{"Hot Dog Stand", "Popcorn Stand", "",""};
    String[] tools = new String[]{"cup","water","candy","sugar"};
    String unReachableDirection = "Cannot go this way";
    station = new Station(name, villain, tools, item, surroundings, unReachableDirection);
  }

  @Test
  public void testGetName() {
    String expected = "Gift Shop";
    String actual = station.getName();
    assertEquals(expected,actual);
  }

  @Test
  public void testGetMonster() {
    Monster expected = new Monster("Balloon Dog Monster",
        "needle",
        "*lets out a continuous cry*. \nYou are quickly surrounded by other balloon animals and they grab you. \nYou start to float away never to be seen again. Game Over.",
        "Quickly you prick the Balloon Dog with a needle, and it drops a silver key.",
        "silver key");
    Monster actual = station.getMonster();
    assertEquals(expected.getName(),actual.getName());
    assertEquals(expected.getKey(),actual.getKey());
    assertEquals(expected.getLostMessage(),actual.getLostMessage());
    assertEquals(expected.getWinMessage(),actual.getWinMessage());
    assertEquals(expected.isAlive(),actual.isAlive());

  }

  @Test
  public void testGetTools() {
    String[] expected = new String[]{"cup","water","candy","sugar"};
    String[] actual = station.getTools();
    assertArrayEquals(expected,actual);
  }

  @Test
  public void testGetItem() {
    String expected = "Gold Key";
    String actual = station.getItem();
    assertEquals(expected,actual);
  }

  @Test
  public void testGetSurroundings() {
    HashMap<Directions,String> expected = new HashMap<>();
    expected.put(Directions.NORTH,"Hot Dog Stand");
    expected.put(Directions.SOUTH,"Popcorn Stand");
    HashMap<Directions,String> actual = station.getSurroundings();
    assertEquals(expected,actual);
  }

  @Test
  public void testGetUnreachableDirectionMessage() {
    String expected = "Cannot go this way";
    String actual = station.getUnreachableDirectionMessage();
    assertEquals(expected,actual);
  }

  @Test
  public void testSetMonster() {
    String[] villain = new String[]{"Balloon Dog Monster",
        "needle",
        "*lets out a continuous cry*. \nYou are quickly surrounded by other balloon animals and they grab you. \nYou start to float away never to be seen again. Game Over.",
        "Quickly you prick the Balloon Dog with a needle, and it drops a silver key.",
        "silver key"};
    Monster expected = new Monster("Balloon Dog Monster",
        "needle",
        "*lets out a continuous cry*. \nYou are quickly surrounded by other balloon animals and they grab you. \nYou start to float away never to be seen again. Game Over.",
        "Quickly you prick the Balloon Dog with a needle, and it drops a silver key.",
        "silver key");
    station.setMonster(villain);
    Monster actual = station.getMonster();
    assertEquals(expected.getName(),actual.getName());
    assertEquals(expected.getKey(),actual.getKey());
    assertEquals(expected.getLostMessage(),actual.getLostMessage());
    assertEquals(expected.getWinMessage(),actual.getWinMessage());
    assertEquals(expected.isAlive(),actual.isAlive());

  }

  @Test
  public void testGetVillain() {
    String[] expected = new String[]{"Balloon Dog Monster",
        "needle",
        "*lets out a continuous cry*. \nYou are quickly surrounded by other balloon animals and they grab you. \nYou start to float away never to be seen again. Game Over.",
        "Quickly you prick the Balloon Dog with a needle, and it drops a silver key.",
        "silver key"};
    String[] actual = station.getVillain();
    for(int i = 0; i < expected.length; i++){
      assertEquals(expected[i],actual[i]);
    }
  }

  @Test
  public void testSetItem() {
    String expected = "master key";
    station.setItem(expected);
    String actual = station.getItem();
    assertEquals(expected,actual);
  }


}