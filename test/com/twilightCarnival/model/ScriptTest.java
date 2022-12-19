package com.twilightCarnival.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ScriptTest {
  public static Script script;
  @BeforeClass
  public static void beforeClass(){
    script = new Script();
    script.load();
  }

  @Test
  public void testGetIntroduction() {
    String expected = "You’re at the carnival with your friends after one too many drinks you end up falling asleep in a ball pit. \nOnce you awake later on that evening, you notice that the carnival has changed into something not so welcoming. \nJourney through the carnival to find four keys to help you escape the Twilight Carnival!";
    String actual = script.getScript().getIntroduction();
    assertEquals(expected,actual);
  }

  @Test
  public void testGetDirections() {
    String expected = "Go North, Go South, Go East, Go West";
    String actual = script.getScript().getDirections();
    assertEquals(expected,actual);
  }

  @Test
  public void testGetToolMessage() {
    String expected = "Choose one of the items to defeat the monster. If you select the wrong item then you will be defeated.";
    String actual = script.getScript().getToolMessage();
    assertEquals(expected,actual);
  }

  @Test
  public void testGetWinMessage() {
    String expected = "You hear, \"Thank you for visiting, come again, and bring your friends.\" \nYou turn around, you wake up.";
    String actual = script.getScript().getWinMessage();
    assertEquals(expected,actual);
  }

  @Test
  public void testGetHelp() {
    String expected = "1. Go [direction] (example: go north, go south, go west, go east)\n2. Pickup [ItemName] (example: pickup map)\n3. View map (if you have a map in your inventory) \n4. Use [tool] (when you defeat a monster.)\n5. Unlock (when you have enough keys and yuo are at the Dreamland Gate)";
    String actual = script.getScript().getHelp();
    assertEquals(expected,actual);
  }

  @Test
  public void testGetPlayAgainMessage() {
    String expected = "Do you want to play again? (y/n)";
    String actual = script.getScript().getPlayAgainMessage();
    assertEquals(expected,actual);
  }

}