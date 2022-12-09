package com.twilightCarnival.view;

import com.twilightCarnival.controller.Game;
import java.util.Scanner;
public class Play {

  private void readJsonFile(){

  }
  public static void main(String[] args) {
    System.out.println("Do you want to play a new Game? (y/n)");
    Scanner input = new Scanner(System.in);
    if(input.nextLine() == "y"){
      Game game = new Game();
    }



  }
}
