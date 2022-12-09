package com.twilightCarnival.controller;

import java.util.HashMap;

public class Station {
  private String name;
  private String monster;
  private String[] tools;
  private String item;
  private HashMap<String, String> surroundings;
  private String unreachableDirectionMessage;

  public Station(String name, String monster, String[] tools, String item, HashMap<String,
      String> surroundings, String unreachableDirectionMessage){
    this.name = name;
    this.monster = monster;
    this.tools = tools;
    this.item = item;
    this.surroundings = surroundings;
    this.unreachableDirectionMessage = unreachableDirectionMessage;
  }

  public String getName() {
    return name;
  }

  public String getMonster() {
    return monster;
  }

  public String[] getTools() {
    return tools;
  }

  public String getItem() {
    return item;
  }

  public HashMap<String, String> getSurroundings() {
    return surroundings;
  }

  public String getUnreachableDirectionMessage() {
    return unreachableDirectionMessage;
  }

  public void setMonster(String monster) {
    this.monster = monster;
  }

  public void setItem(String item) {
    this.item = item;
  }
}
