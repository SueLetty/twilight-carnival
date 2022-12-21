package com.twilightCarnival.model;

import java.util.HashMap;

public class Station {

  private String name;
  private String item;
  private String[] villain;
  private Monster monster;
  private String[] surroundings = new String[4];
  private String[] tools;
  private String unReachableDirection;
  private String locationDescription;

  public Station(String name, String[] villain, String[] tools, String item, String[] surroundings, String unReachableDirection){
    this.name = name;
    this.villain = villain;
    this.monster = setMonster(this.villain);
    this.tools = tools;
    this.item = item;
    this.surroundings = surroundings;
    this.unReachableDirection = unReachableDirection;
  }

  public void displayTools() {
    for (int i = 0; i < getTools().length; i++) {
      System.out.println(i + 1 + ". " + getTools()[i]);
    }
  }


  public String getName() {
    return name;
  }

  public Monster getMonster() {
    return this.monster;
  }

  public String[] getTools() {
    return tools;
  }

  public String getItem() {
    return item;
  }

  public String getLocationDescription(){
    return locationDescription;
  }

  public HashMap<Directions, String> getSurroundings() {
    HashMap<Directions, String> result = new HashMap<>();
    if (surroundings[0].length() > 0) {
      result.put(Directions.NORTH, surroundings[0]);
    }
    if (surroundings[1].length() > 0) {
      result.put(Directions.SOUTH, surroundings[1]);
    }
    if (surroundings[2].length() > 0) {
      result.put(Directions.EAST, surroundings[2]);
    }
    if (surroundings[3].length() > 0) {
      result.put(Directions.WEST, surroundings[3]);
    }

    return result;
  }


  public String getUnreachableDirectionMessage() {
    return unReachableDirection;
  }

  public Monster setMonster(String[] villain) {
    if (villain.length > 0) {
      this.monster = new Monster(villain[0], villain[1], villain[2], villain[3], villain[4]);
      return this.monster;
    }
    this.monster = new Monster();
    return this.monster;
  }

  public String[] getVillain() {
    return this.villain;
  }

  public void setItem(String item) {
    this.item = item;
  }
}
