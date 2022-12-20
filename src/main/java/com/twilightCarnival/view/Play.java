package com.twilightCarnival.view;

import com.twilightCarnival.controller.StartGame;
import java.util.Scanner;

public class Play {

  public static void main(String[] args) throws InterruptedException {
    StartGame startGame = new StartGame();
    System.out.println(startGame.getTitleCard1());
    System.out.println(startGame.getClown());
    boolean condition = false;
    do{
      System.out.println("Do you want to start a new game?(y/n)");
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      if(input.equalsIgnoreCase("y")){
        startGame.start();
      }else if(input.equalsIgnoreCase("n")){
        if(startGame.getGame().quit()){
          startGame.start();
        }else{
          startGame.getGame().quitFromStaredGame();
        }
      }else{
        System.out.println("It is not a valid input. Please use 'y' or 'n'.");
        condition = true;
      }
    }while(condition);

  }
}
