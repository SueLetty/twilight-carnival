package com.twilightCarnival.controller;

import com.twilightCarnival.model.Directions;
import com.twilightCarnival.model.InputValidator;
import java.util.Scanner;

public class StartGame {

  Game game = new Game();

  public void start(){
    System.out.println("Do you want to play a new Game? (y/n)");
    Scanner input = new Scanner(System.in);
    if(input.nextLine().equalsIgnoreCase("y")){
      game.display();
      game.status();  //need to override?
      userInput();
      System.out.println("Do you want to play again? (y/n)");
      input = new Scanner(System.in);
      if(input.nextLine().equalsIgnoreCase("y")){
        game.playAgain();
      }

    }else{
      System.out.println("Are you sure?(y/n)");
      input = new Scanner(System.in);
      if(input.nextLine().equals("y")){
        game.quit();
      }else{
        game.playAgain();
      }
    }
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

      game.getItem(noun);
      game.getPlayer().displayInventory();
    } else if (verb.equals("go")) {

      game.changingLocation(Directions.valueOf(noun));
    }
  }
}
