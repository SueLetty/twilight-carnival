package com.twilightCarnival.controller;
import com.twilightCarnival.model.Directions;
import com.twilightCarnival.model.Player;
import com.twilightCarnival.model.Script;
import com.twilightCarnival.model.SetMap;
import com.twilightCarnival.model.Station;
import java.util.List;
import java.util.Scanner;
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
    System.out.println(getTryAgainMessage());
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if(input.equalsIgnoreCase("y")){
      StartGame startGame = new StartGame();
      startGame.start();
    }else if(input.equalsIgnoreCase("n")){
      quit();
    } else{
      System.out.println("That is not valid input. Please type y or n.");
      playAgain();
    }
  }
  public void getItem(String item){

    for(Station s: stations){
      if(s.getName().equals(player.getCurrentLocation()) && s.getItem().equals(item)){
        System.out.printf("You picked up the %s and added it to your inventory\n", item);
        player.setInventory(s.getItem());
        s.setItem(null);
        return;
      } else if (s.getName().equals(player.getCurrentLocation()) && s.getItem()== null){
        System.out.println("There are no items you can pickup.");
      }
    }
  }
  public void status(){
    System.out.println("=============================================================================================");
    System.out.println("Location:" + player.getCurrentLocation() + "\t Tokens: " + player.getToken() + "\tInventory: [" + player.displayInventory() + "]");
    System.out.println("=============================================================================================\n\n");
    System.out.println("Available commands: go [direction], help");
    System.out.println("=============================================================================================");

    for(Station s: stations){
      if(s.getName().equals(player.getCurrentLocation()) && getPlayer().hasMap()){
        System.out.println("There is a map in your inventory.");
        System.out.println("You can view map.");
      }
      if(s.getName().equals(player.getCurrentLocation()) && s.getItem() != null && !s.getItem().equalsIgnoreCase("NULL")){
        System.out.println("There is a " + s.getItem() + ".");
        System.out.println("You can pickup " + s.getItem() + ".");
      }
      if(s.getName().equals(player.getCurrentLocation())  && s.getMonster().getName() != null && s.getMonster().isAlive()){
        System.out.println("There is a " + s.getMonster().getName() + "!");
        System.out.println("Choose one of the tools displayed to defeat the" + " " +s.getMonster().getName() + "." + " " + "Example: use water.");
        s.displayTools();
      }


    }
    System.out.println("=============================================================================================");

  }

  /**
   * viewMap() will display the locations adjacent to the player's current location.
   *  It will color red if not visited before and green if previously visited.
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
  public void quitFromStaredGame(){
    System.out.println("Do you really want to quit the game?(y/n)");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if(input.equalsIgnoreCase("y")){
      System.out.println("Thank you! Have a great day!");
      System.exit(0);
    }else if(input.equalsIgnoreCase("n")){
      System.out.println("Thanks for staying with us! Please enter a command to continue");
    } else{
      System.out.println("That is not valid input. Please type y or n.");
      quitFromStaredGame();
    }
  }
  public boolean quit(){
    System.out.println("are you sure?(y/n)");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if(input.equalsIgnoreCase("y")){
      System.out.println("Thank you! Have a great day!");
      System.exit(0);
    }else if(input.equalsIgnoreCase("n")){
      System.out.println("You can start the game.");
      return true;
    } else{
      System.out.println("That is not valid input. Please type y or n.");
      quit();
    }
    return false;
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
  public void defeatMonsterOrLoseGame(String noun){
    if(isMonsterDefeated(noun)){
      for(Station s:stations){
        if(s.getName().equals(player.getCurrentLocation())){
          s.getMonster().setStatus(false);
          player.setInventory(s.getMonster().getKey());
          System.out.println(s.getMonster().getWinMessage());
          System.out.println("You earned a " + s.getMonster().getKey()+".");
          System.out.println("It is in your inventory now.");
          s.getMonster().setKey(null);
          return;

        }
      }

    }else{
      if(player.getToken() > 0){
        System.out.println("You have " + player.getToken() + " tokens.");
        boolean condition = false;
        do{
          System.out.println("Do you want to use 1 token to defeat the monster again?(y/n)");
          Scanner scanner = new Scanner(System.in);
          String input = scanner.nextLine();
          if(input.equalsIgnoreCase("y")){
            System.out.println("Choose a tool to defeat monster. Example: use water");
            player.setToken(player.getToken()-1);
            condition = false;
          }else if(input.equalsIgnoreCase("n")){
            System.out.println("You can explore other stations.");
            condition = false;
          } else{
            System.out.println("That is not valid input. Please type y or n.");
            condition = true;
          }
        }while(condition);
      }else{
        for(Station s:stations){
          if(s.getName().equals(player.getCurrentLocation())){
            System.out.println(s.getMonster().getLostMessage());
            playAgain();
            return;
          }
        }
      }
    }
  }

  public void win(){
    if(player.getCurrentLocation().equalsIgnoreCase("Dreamland Gate")){
      if(player.getInventory().contains("master key")
          && player.getInventory().contains("gold key")
          && player.getInventory().contains("silver key")
          && player.getInventory().contains("bronze key")){
        System.out.println(getWinMessage());
        playAgain();
      }

    }
    System.out.println("You don't have enough keys to escape."
        + "\nYou need to go to defeat monsters and earn more keys."
        + "\nYou need four keys to open Dreamland Gate to escape.");

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


