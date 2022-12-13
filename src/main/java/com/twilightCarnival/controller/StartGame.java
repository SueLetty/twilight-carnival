package com.twilightCarnival.controller;

import com.twilightCarnival.model.InputValidator;
import java.util.Scanner;

public class StartGame {

  Game game = new Game();

  public void start(){
    System.out.println("Do you want to play a new Game? (y/n)");
    Scanner input = new Scanner(System.in);
    if(input.nextLine().equals("y")){
      System.out.println("Game started!");
      game.display();
      game.status();  //need to override?
      userInput();
    }
    game.quit();
  }


  private void userInput(){
    InputValidator validator = new InputValidator();
    String[] validInput = new String[2];
    Scanner input = new Scanner(System.in);
    String userChoice = "";
    while (true){
      userChoice = input.nextLine();
      if (userChoice.equals("")){
        System.out.println("Please enter a command.");
      } else if (userChoice.toLowerCase().equals("help")) {
        game.help();
      } else if (userChoice.toLowerCase().equals("quit")) {
        game.quit();
      } else if (validator.isValid(userChoice)) {
        validInput = validator.getInput();
        operation(validInput[0], validInput[1]);
        game.status();
        // verb is in validInput[0]
        // noun is in validInput[1]
        // use validInput to do something
        continue;
      }
    }
  }

  private void operation(String verb, String noun){
    if (verb.equals("open") && noun.equals("map")){
      if (game.getPlayer().hasMap()){
        game.viewMap();
      }else {
        System.out.println("You do not have a map.");
      }
    } else if (verb.equals("pickup")) {
      // TODO: 12/13/2022 get current location and check for items to pickup
      // call status here?, message below might not display.
      System.out.printf("You picked up the %s and added it to your inventory", noun);
      game.getPlayer().setInventory(noun);
    } else if (verb.equals("go")) {
      // TODO: 12/13/2022 change locations
    }
  }
}
