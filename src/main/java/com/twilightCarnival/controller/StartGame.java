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
      game.status();
      userInput();
    }
    game.quit();
  }


  public void userInput(){
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
        // verb is in validInput[0]
        // noun is in validInput[1]
        // use validInput to do something
        continue;
      }
    }
  }
}
