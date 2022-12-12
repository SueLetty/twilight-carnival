package com.twilightCarnival.view;

import com.twilightCarnival.controller.Game;
import java.util.Scanner;
public class Play {


  public static void main(String[] args) {
    System.out.println("Do you want to play a new Game? (y/n)");
    Scanner input = new Scanner(System.in);
    if(input.nextLine().equals("y")){
      System.out.println("Game started!");
      Game game = new Game();
      System.out.println("Do you need help?");
      input = new Scanner(System.in);
      if(input.nextLine().equals("help")){
        game.help();
      }
      System.out.println("Do you need help?");
      input = new Scanner(System.in);
      if(input.nextLine().equals("quit")){
        game.quit();
      }

    }





  }
}
