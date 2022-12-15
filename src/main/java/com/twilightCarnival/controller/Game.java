package com.twilightCarnival.controller;
import com.twilightCarnival.model.Directions;
import com.twilightCarnival.model.Player;
import com.twilightCarnival.model.Script;
import com.twilightCarnival.model.SetMap;
import com.twilightCarnival.model.Station;
import java.util.List;
import java.util.Stack;



public class Game {

  private Player player;
  private Script script;
  private SetMap map;
  private List<Station> stations;
  private Stack<String> stationsVisited = new Stack<>();

  public Game() {
    player = new Player();
    script= new Script();
    script.load();
    map = new SetMap();
    map.load();
    for(Station s: map.getStations()){
      s.setMonster(s.getVillain());
    }
    stations = map.getStations();

  }
  public void playAgain(){
    StartGame startGame = new StartGame();
    startGame.start();

  }
  public void getItem(String item){

    for(Station s: stations){
      if(s.getName().equals(player.getCurrentLocation()) && s.getItem().equals(item)){
        System.out.printf("You picked up the %s and added it to your inventory\n", item);
        player.setInventory(s.getItem());
        s.setItem(null);
        return;
      } else if (s.getName().equals(player.getCurrentLocation()) && s.getItem()== null){
        System.out.println("There is no items you can pickup.");
      }
    }
  }
  public void status(){
    System.out.println("=============================================================================================");
    System.out.println("Location:" + player.getCurrentLocation() + "\t Tokens: " + player.getToken() + "\tInventory: [" + player.displayInventory() + "]");
    System.out.println("=============================================================================================\n\n");
    System.out.println("Available command: go [direction]");
    System.out.println("=============================================================================================");

    for(Station s: stations){
      if(s.getName().equals(player.getCurrentLocation()) && getPlayer().hasMap()){
        System.out.println("There is a map in your inventory.");
        System.out.println("You can view map");
      }
      if(s.getName().equals(player.getCurrentLocation()) && !s.getItem().equals("NULL")){
        System.out.println("There is a " + s.getItem());
        System.out.println("You can pickup " + s.getItem());
      }
      if(s.getName().equals(player.getCurrentLocation()) && s.getMonster().getName() != null){
        System.out.println("There is a " + s.getMonster().getName());
        System.out.println("Choose one of the tools displayed. Example: use water");
        s.displayTools();
      }

    }
    System.out.println("=============================================================================================");

  }

  /**
   * viewMap() will display the locations adjacent to the player's current location.
   *  It will color red if not visited before and green if previously visted.
   *  red = \u001B[31m
   *  green = \u001B[32m
   */
  public void viewMap(){
    if(player.hasMap()){
      System.out.println("Your current location surroundings are: ");
      for(Station s: stations){
        if(s.getName().equals(player.getCurrentLocation())){
          for(Directions direction: s.getSurroundings().keySet()){
            String adjacentLocation = s.getSurroundings().get(direction);
            if(hasBeenVisited(adjacentLocation)){
              System.out.println(direction + ": " + "\u001B[32m" + adjacentLocation + "\u001B[0m");
            }else {
              System.out.println(direction + ": " + "\u001B[31m" + adjacentLocation + "\u001B[0m");

            }
          }
        }
      }
    }else{
      System.out.println("You don't have a map to view.");
    }
  }

  /**
   * when the user type "quit", it quits the game
   */
  public void quit(){
    System.out.println("Thank you! Have a great day!");
    System.exit(0);

  }
  public void help(){
    System.out.println(getHelpMessage());

  }
  public void display(){
    System.out.println(getIntroduction());

  }

  public boolean isMonsterDefeated(String noun){
    for(Station s:stations){
      if(s.getName().equals(player.getCurrentLocation()) && s.getMonster() != null){
        if(noun.equals(s.getMonster().getWeakness())){
          return true;
        }

      }
    }

    return false;
  }


  /**
   * changingLocations will change the player's current location to chosen valid location.
   *  stationsVisited is tracked here through trackLocation() method call. Needs to be called before
   *  setting new location.
   * @param direction the user wants to move.
   */
  public void changingLocation(Directions direction){
    for(Station s: stations){
      if(s.getName().equals(player.getCurrentLocation())){
        if(s.getSurroundings().containsKey(direction)){
          trackLocation();
          player.setCurrentLocation(s.getSurroundings().get(direction));
          System.out.print("\033[H\033[2J");
          System.out.flush();
          status();
          return;
        }
        else{
          System.out.println(s.getUnreachableDirectionMessage());
        }

      }
    }
  }

  /**
   * Method tracks the current player and adds it to the stationsVisited.
   */
  private void trackLocation(){
    if(!hasBeenVisited(player.getCurrentLocation())){
      stationsVisited.push(player.getCurrentLocation().toLowerCase());
    }
  }

  /**
   * hasBeenVisited() will check if the location has been tracked in stationsVisited.
   * @param location to searched in tracked locations.
   * @return true if visited, otherwise false.
   */
  private boolean hasBeenVisited(String location){
    return stationsVisited.contains(location.toLowerCase());
  }

  public Player getPlayer() {
    return player;

  }


  /**
   * getCurrentStation gets the current station the player is located in. we could always track it
   * in a field, but this was created in absence of that.
   * @return current station.
   */
  public Station getCurrentStation(){
    Station currentStation = null;
    for (Station station: stations){
      if (station.getName().equalsIgnoreCase(player.getCurrentLocation())){
        currentStation = station;
      }
    }
    return currentStation;
  }

  public String getHelpMessage() {
    return script.getScript().getHelp();
  }

  public String getTryAgainMessage() {
    return script.getScript().getPlayAgainMessage();
  }

  public String getIntroduction() {
    return script.getScript().getIntroduction();
  }

  public String getWinMessage() {
    return script.getScript().getWinMessage();
  }

  public String getInstructionForTools() {
    return script.getScript().getToolMessage();
  }

}


