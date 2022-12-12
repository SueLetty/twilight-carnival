package com.twilightCarnival.controller;
import com.twilightCarnival.model.Directions;
import com.twilightCarnival.model.Monster;
import com.twilightCarnival.model.Player;

import com.twilightCarnival.model.Station;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
//  private List<String> inputs;
  private Monster cottonCandyMonster;
  private Monster balloonDog;
  private Monster popcornSnake;

  private String[] cottonCandyTools =new String[]{"fork","sugar","cup","water"};
  private String[] balloonDogTools = new String[]{"needle", "rubber duck", "soda", "water"};
  private String[] popcornSnakeTools = new String[]{"broom", "candy", "butter", "cup"};

  private HashMap<String, String> ballPitSurroundings = new HashMap<>();
  private HashMap<String, String> giftShopSurroundings = new HashMap<>();
  private HashMap<String, String> cottonCandyStandSurroundings = new HashMap<>();
  private HashMap<String, String> safeAreaSurroundings = new HashMap<>();
  private HashMap<String, String> popcornStandSurroundings = new HashMap<>();
  private HashMap<String, String> hotDogStandSurroundings = new HashMap<>();
  private HashMap<String, String> dreamlandGateSurroundings = new HashMap<>();

  private Station cottonCandyStand;
  private Station hotDogStand;
  private Station popcornStand;
  private Station giftShop;
  private Station safeArea;
  private Station ballPit;
  private Station dreamlandGate;
  public Game() {
    welcomeMessage = "Welcome to Twilight Carnival!";
    helpMessage = "1. Go [direction] (example: go north, go south, go west, go east)\n2. Pickup [ItemName] (example: pickup map)\n3. View map (if you have a map in your inventory) ";
//    player = new Player();
    stations = new ArrayList<>();
    cottonCandyMonster = new Monster("Cotton Candy Monster", "water","Gold Key",
                          "The Cotton Candy Monster shrivels up and deteriorates into a pink goo. Within the goo there is a key. You pick it up.",
                          "The Cotton Candy Monster did not like that. The Monster grabs you spins you in the cotton candy machine. You are now a Cotton Candy Monster. Game Over.");
    balloonDog = new Monster("Balloon Dog","needle","Silver Key",
                          "Quickly you prick the Balloon dog with a needle, and it drops a key. You pick it up.",
                          "lets out a continuous cry. You are quickly surrounded by other balloon animals and they grab you. You start to float away to never to be seen again. Game Over.");
    popcornSnake = new Monster("Popcorn Snake","Popcorn Snake","Bronze Key",
                          "You grab the broom and sweep up Popcorn Snake into the trash. It leaves behind a key. You pick it up.",
                          "The Popcorn Snake is not fazed by your actions. It completely wraps around you, and drags you into the popcorn machine. You are now a popcorn snake. Game Over.");
    ballPitSurroundings.put("North", "Cotton Candy Stand");
    ballPitSurroundings.put("South", "Dreamland Gate");
    ballPitSurroundings.put("East", "Popcorn Stand");
    ballPitSurroundings.put("West", "Hot Dog Stand");

    giftShopSurroundings.put("South", "Hot Dog Stand");
    giftShopSurroundings.put("East", "Cotton Candy Stand");

    cottonCandyStandSurroundings.put("South", "Ball Pit");
    cottonCandyStandSurroundings.put("East", "Safe Area");
    cottonCandyStandSurroundings.put("West", "Gift Shop");

    safeAreaSurroundings.put("South", "Popcorn Stand");
    safeAreaSurroundings.put("West", "Cotton Candy Stand");

    popcornStandSurroundings.put("North", "Safe Area");
    popcornStandSurroundings.put("West", "Ball Pit");

    hotDogStandSurroundings.put("North", "Gift Shop");
    hotDogStandSurroundings.put("East", "Ball Pit");

    dreamlandGateSurroundings.put("North", "Ball Pit");
    cottonCandyStand = new Station("Cotton Candy Stand", cottonCandyMonster,cottonCandyTools, null,cottonCandyStandSurroundings, "There is a pile of paper cones");
    hotDogStand = new Station("Hot Dog Stand", null,null, "Master Key",hotDogStandSurroundings, "There is a pile of mustard bottles");
    popcornStand = new Station("Popcorn Stand", popcornSnake,popcornSnakeTools, null,popcornStandSurroundings, "There is a pile of kernels paper bags");
    giftShop = new Station("Gift Shop", balloonDog,balloonDogTools, null,giftShopSurroundings, "There is a pile of bobble heads");
    safeArea = new Station("Safe Area", null,null, "Map",safeAreaSurroundings, "There is a pile of peanuts");
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
  public void tryAgain(){
    System.out.println("Do you want to play again?");

  }
  public void quit(){
    System.exit(1);

  }
  public void help(){
    System.out.println(getHelpMessage());

  }
  public void display(){
    System.out.println(getWelcomeMessage());
    System.out.println(getIntroduction());

  }


  public Player getPlayer() {
    return player;
  }

  public String getWelcomeMessage() {
    return welcomeMessage;
  }

  public List<Station> getStations() {
    for(Station s: stations){
      System.out.println(s);
    }
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


