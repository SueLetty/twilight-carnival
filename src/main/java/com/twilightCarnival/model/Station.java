package com.twilightCarnival.model;

import java.util.HashMap;

public class Station {
  private String name;
  private Monster monster;
  private String[] tools;
  private String item;
  private HashMap<String, String> surroundings;
  private String unreachableDirectionMessage;

  public Station(String name, Monster monster, String[] tools, String item, HashMap<String,
      String> surroundings, String unreachableDirectionMessage){
    this.name = name;
    this.monster = monster;
    this.tools = tools;
    this.item = item;
    this.surroundings = surroundings;
    this.unreachableDirectionMessage = unreachableDirectionMessage;
  }
  public boolean hasMonster(){

    return getMonster() == null ? false: true;
  }
  public boolean hasItem(){
    return getItem() == null ? false: true;
  }
  public void displayTools(){
    for(int i = 0; i < getTools().length; i++){
      System.out.println(i+1 + ", " + getTools()[i]);
    }
  }
  public String getName() {
    return name;
  }

  public Monster getMonster() {
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

  public void setMonster(Monster monster) {
    this.monster = monster;
  }

  public void setItem(String item) {
    this.item = item;
  }
}
