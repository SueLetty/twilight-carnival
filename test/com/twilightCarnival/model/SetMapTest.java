package com.twilightCarnival.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SetMapTest {
  public static SetMap map;
  @BeforeClass
  public static void beforeClass(){
    map = new SetMap();
    map.load();
  }

  @Test
  public void testGetStations() {
    String[] stationsName = new String[]{"Ball Pit","Gift Shop","Cotton Candy Stand","Safe Area","Popcorn Stand","Hot Dog Stand","Dreamland Gate"};
    int i = 0;
    for(Station s: map.getStations()){
      String expected = stationsName[i++];
      String actual = s.getName();
      assertEquals(expected,actual);
    }
  }
}