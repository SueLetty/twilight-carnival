package com.twilightCarnival.model;

import java.util.HashSet;

public class Player {
  private HashSet<String> inventory;
  private int token;
  private final int NUMBER_OF_TOKENS = 3;
  private String currentLocation;

  public Player(HashSet<String> inventory){
    this.inventory = inventory;
    token = NUMBER_OF_TOKENS;
    currentLocation = "Ball Pit";
  }
  public boolean hasMap(){
    return inventory.contains("map");
  }

  public int numberOfKeys(){
    return hasMap() ? inventory.size() -1: inventory.size();
  }
  public HashSet<String> getInventory() {
    return inventory;
  }

  public void setInventory(HashSet<String> inventory) {
    this.inventory = inventory;
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
