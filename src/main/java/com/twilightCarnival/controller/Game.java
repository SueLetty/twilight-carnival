package com.twilightCarnival.controller;
import com.twilightCarnival.model.Directions;
import com.twilightCarnival.model.Player;

import java.util.List;

public class Game {

  private Player player;
  private String welcomeMessage;
  private List<String> stations;
  private String helpMessage;
  private String tryAgainMessage;
  private Directions direction;
  private List<String> inputs;


  public void Game() {



  }
  public void tryAgain(){
    System.out.println("Do you want to play again?");

  }

  /**
   * when the user type "quit", it quits the game
   */
  public void quit(){
    System.exit(1);

  }
  public void help(){
    System.out.println("1. Go [direction] (example: go north, go south, go west, go east)\n2. Pickup [ItemName] (example: pickup map)\n3. View map (if you have a map in your inventory) ");

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

  public List<String> getInputs() {
    if(inputs != null){
      for(String list: inputs){
        System.out.println(list);
      }
    }else{
      System.out.println("input is null");
    }


    return inputs;
  }

  public void setInputs(List<String> inputs) {
    this.inputs = inputs;
  }
}


