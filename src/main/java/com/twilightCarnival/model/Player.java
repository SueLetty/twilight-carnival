package com.twilightCarnival.model;

import java.util.HashSet;

public class Player {
  private HashSet<String> inventory;
  private int token;
  private final int NUMBER_OF_TOKENS = 3;
  private String currentLocation;

  public Player(){
    inventory = new HashSet<>();
    token = NUMBER_OF_TOKENS;
    currentLocation = "Ball Pit";
  }
  public boolean hasMap(){
    return inventory.contains("map");
  }

  public String displayInventory(){
    StringBuilder result= new StringBuilder();
    if(getInventory().size()!=0){
      for(String item: inventory){
        result.append(item).append(", ");
      }
    }

    return result.toString().replaceAll(", $","");
  }

  public HashSet<String> getInventory() {
    return inventory;
  }


  public void setInventory(String item) {
    this.inventory.add(item);
  }

  public int getToken() {
    return token;
  }

  public void setToken(int token) {
    this.token = token;
  }

  public String getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(String currentLocation) {
    this.currentLocation = currentLocation;
  }
}
