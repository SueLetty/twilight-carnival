package com.twilightCarnival.controller;
import com.twilightCarnival.model.Directions;
import com.twilightCarnival.model.Monster;
import com.twilightCarnival.model.Player;

import com.twilightCarnival.model.Station;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;


public class Game {

  private Player player;
  private String welcomeMessage;
  private String introduction;
  private String winMessage;
  private String instructionForTools;
  private List<Station> stations;
  private String helpMessage;
  private String tryAgainMessage;
  private Directions direction;
  private Monster cottonCandyMonster;
  private Monster balloonDog;
  private Monster popcornSnake;

  private String[] cottonCandyTools =new String[]{"fork","sugar","cup","water"};
  private String[] balloonDogTools = new String[]{"needle", "rubber duck", "soda", "water"};
  private String[] popcornSnakeTools = new String[]{"broom", "candy", "butter", "cup"};

  private HashMap<Directions, String> ballPitSurroundings = new HashMap<>();
  private HashMap<Directions, String> giftShopSurroundings = new HashMap<>();
  private HashMap<Directions, String> cottonCandyStandSurroundings = new HashMap<>();
  private HashMap<Directions, String> safeAreaSurroundings = new HashMap<>();
  private HashMap<Directions, String> popcornStandSurroundings = new HashMap<>();
  private HashMap<Directions, String> hotDogStandSurroundings = new HashMap<>();
  private HashMap<Directions, String> dreamlandGateSurroundings = new HashMap<>();

  private Station cottonCandyStand;
  private Station hotDogStand;
  private Station popcornStand;
  private Station giftShop;
  private Station safeArea;
  private Station ballPit;
  private Station dreamlandGate;

  private Stack<String> stationsVisited = new Stack<>();

  public Game() {
    player = new Player();
    tryAgainMessage = "Do you want to play again?(y/n)";
    welcomeMessage = "Welcome to Twilight Carnival!";
    helpMessage = "1. Go [direction] (example: go north, go south, go west, go east)\n2. Pickup [ItemName] (example: pickup map)\n3. View map (if you have a map in your inventory) ";
    stations = new ArrayList<>();
    cottonCandyMonster = new Monster("Cotton Candy Monster", "water","Gold Key",
                          "The Cotton Candy Monster shrivels up and deteriorates into a pink goo. Within the goo there is a key. You pick it up.",
                          "The Cotton Candy Monster did not like that. The Monster grabs you spins you in the cotton candy machine. You are now a Cotton Candy Monster. Game Over.");
    balloonDog = new Monster("Balloon Dog Monster","needle","Silver Key",
                          "Quickly you prick the Balloon dog with a needle, and it drops a key. You pick it up.",
                          "lets out a continuous cry. You are quickly surrounded by other balloon animals and they grab you. You start to float away to never to be seen again. Game Over.");
    popcornSnake = new Monster("Popcorn Snake Monster","Popcorn Snake","Bronze Key",
                          "You grab the broom and sweep up Popcorn Snake into the trash. It leaves behind a key. You pick it up.",
                          "The Popcorn Snake is not fazed by your actions. It completely wraps around you, and drags you into the popcorn machine. You are now a popcorn snake. Game Over.");
    ballPitSurroundings.put(Directions.NORTH, "Cotton Candy Stand");
    ballPitSurroundings.put(Directions.SOUTH, "Dreamland Gate");
    ballPitSurroundings.put(Directions.EAST, "Popcorn Stand");
    ballPitSurroundings.put(Directions.WEST, "Hot Dog Stand");

    giftShopSurroundings.put(Directions.SOUTH, "Hot Dog Stand");
    giftShopSurroundings.put(Directions.EAST, "Cotton Candy Stand");

    cottonCandyStandSurroundings.put(Directions.SOUTH, "Ball Pit");
    cottonCandyStandSurroundings.put(Directions.EAST, "Safe Area");
    cottonCandyStandSurroundings.put(Directions.WEST, "Gift Shop");

    safeAreaSurroundings.put(Directions.SOUTH, "Popcorn Stand");
    safeAreaSurroundings.put(Directions.WEST, "Cotton Candy Stand");

    popcornStandSurroundings.put(Directions.NORTH, "Safe Area");
    popcornStandSurroundings.put(Directions.WEST, "Ball Pit");

    hotDogStandSurroundings.put(Directions.NORTH, "Gift Shop");
    hotDogStandSurroundings.put(Directions.EAST, "Ball Pit");

    dreamlandGateSurroundings.put(Directions.NORTH, "Ball Pit");
    cottonCandyStand = new Station("Cotton Candy Stand", cottonCandyMonster,cottonCandyTools, null,cottonCandyStandSurroundings, "There is a pile of paper cones");
    hotDogStand = new Station("Hot Dog Stand", null,null, "master key",hotDogStandSurroundings, "There is a pile of mustard bottles");
    popcornStand = new Station("Popcorn Stand", popcornSnake,popcornSnakeTools, null,popcornStandSurroundings, "There is a pile of kernels paper bags");
    giftShop = new Station("Gift Shop", balloonDog,balloonDogTools, null,giftShopSurroundings, "There is a pile of bobble heads");
    safeArea = new Station("Safe Area", null,null, "map",safeAreaSurroundings, "There is a pile of peanuts");
    ballPit = new Station("Ball Pit", null,null, null,ballPitSurroundings, null);
    dreamlandGate = new Station("Dreamland Gate",null,null, null,dreamlandGateSurroundings, "There is wrought iron fencing");

    stations.add(cottonCandyStand);
    stations.add(hotDogStand);
    stations.add(popcornStand);
    stations.add(giftShop);
    stations.add(safeArea);
    stations.add(ballPit);
    stations.add(dreamlandGate);

    welcomeMessage = "Welcome to Twilight Carnival!";
    introduction = "You’re at the carnival with your friends after one too many drinks you end up falling asleep in a ball pit. \nOnce you awake later on that evening, you notice that the carnival has changed into something not so welcoming. \nJourney through the carnival to find four keys to help you escape the Twilight Carnival!";
    winMessage = "You hear, \"Thank you for visiting, come again, and bring your friends.\" \n\nYou turn around, you wake up.";
    instructionForTools = "Choose one of the items to defeat the monster. If you select the wrong item then you will be defeated.";
  }
  public void playAgain(){

    StartGame startGame = new StartGame();
    startGame.start();


  }
  public void getItem(String item){

    for(Station s: stations){
      if(s.getName().equals(player.getCurrentLocation()) && s.hasItem() && item.equals(s.getItem())){
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
      if(s.getName().equals(player.getCurrentLocation()) && s.hasItem()){
        System.out.println("There is a " + s.getItem());
        System.out.println("You can pickup " + s.getItem());
      }
      if(s.getName().equals(player.getCurrentLocation()) && s.hasMonster()){
        System.out.println("There is a " + s.getMonster().getName());
        System.out.println("if there is a monster, choose one of the tools displayed. Type 1, 2, 3, or 4");
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

  public boolean isMonsterDefeated(int input){
    for(Station s:stations){
      if(s.getName().equals(player.getCurrentLocation()) && s.hasMonster()){
        if(s.getTools()[input-1].equals(s.getMonster().getWeakness())){
//          System.out.println(s.getMonster().getWinMessage());
//          getPlayer().setInventory(s.getItem());
          return true;
        }

      }
    }

    return false;
  }

  public Player getPlayer() {
    return player;
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

  /**
   * Players are presented with a Title.Splash Screen
   * @return a welcome message
   */
  public String getWelcomeMessage() {
    return welcomeMessage;
  }

  public List<Station> getStations() {
    for(Station s: stations){
      System.out.println(s);
    }
    return stations;
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

  public void setStations(Station station) {
    this.stations.add(station);
  }

  public String getIntroduction() {
    return introduction;
  }

  public String getWinMessage() {
    return winMessage;
  }

  public String getInstructionForTools() {
    return instructionForTools;
  }

  public Monster getCottonCandyMonster() {
    return cottonCandyMonster;
  }

  public Monster getBalloonDog() {
    return balloonDog;
  }

  public Monster getPopcornSnake() {
    return popcornSnake;
  }

  public Station getCottonCandyStand() {
    return cottonCandyStand;
  }

  public Station getHotDogStand() {
    return hotDogStand;
  }

  public Station getPopcornStand() {
    return popcornStand;
  }

  public Station getGiftShop() {
    return giftShop;
  }

  public Station getSafeArea() {
    return safeArea;
  }

  public Station getBallPit() {
    return ballPit;
  }

  public Station getDreamlandGate() {
    return dreamlandGate;
  }
//  public List<String> getInputs() {
//    if(inputs != null){
//      for(String list: inputs){
//        System.out.println(list);
//      }
//    }else{
//      System.out.println("input is null");
//    }
//
//
//    return inputs;
//  }
//
//  public void setInputs(List<String> inputs) {
//    this.inputs = inputs;
//  }
}


