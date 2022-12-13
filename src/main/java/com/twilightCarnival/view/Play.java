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
      game.display();
      game.status();

    }





  }
}
