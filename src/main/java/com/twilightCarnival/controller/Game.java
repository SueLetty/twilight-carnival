package com.twilightCarnival.controller;

import com.twilightCarnival.model.Directions;
import com.twilightCarnival.model.Player;
import java.util.ArrayList;
import java.util.List;

public class Game {

  private Player player;
  private String welcomeMessage;
  private List<String> stations;
  private String helpMessage;
  private String tryAgainMessage;
  private Directions direction;


  public void Game(Player player, String welcomeMessage, String helpMessage, String tryAgainMessage ) {
    this.player = player;
    this.welcomeMessage = welcomeMessage;
    this.helpMessage = helpMessage;
    this.tryAgainMessage = tryAgainMessage;
    this.stations = new ArrayList<>();
    this.direction = direction;

  }
  public void tryAgain(){

  }
  public void quit(){

  }
  public void help(){

  }
  public void display(){

  }


  public Player getPlayer() {
    return player;
  }

  public String getWelcomeMessage() {
    return welcomeMessage;
  }

  public List<String> getStations() {
    return stations;
  }

  public String getHelpMessage() {
    return helpMessage;
  }

  public String getTryAgainMessage() {
    return tryAgainMessage;
  }

  public Directions getDirection() {
    return direction;
  }

  public void setDirection(Directions direction) {
    this.direction = direction;
  }

  public void setStations(String station) {
    this.stations.add(station);
  }

}


