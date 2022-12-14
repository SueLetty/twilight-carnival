package com.twilightCarnival.model;

public class Monster {
  private String name;
  private String weakness;
  private String lostMessage;
  private String winMessage;
  private String key;
  private boolean status;





  public Monster(String name, String weakness, String key, String winMessage, String lostMessage){
    this.name = name;
    this.weakness = weakness;
    this.key = key;
    this.winMessage = winMessage;
    this.lostMessage = lostMessage;

  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public boolean isAlive() {
    return status;
  }

  public String getWeakness() {
    return weakness;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getWinMessage() {
    return winMessage;
  }

  public String getLostMessage() {
    return lostMessage;
  }
}
