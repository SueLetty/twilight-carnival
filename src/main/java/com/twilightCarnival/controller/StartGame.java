package com.twilightCarnival.controller;

import com.twilightCarnival.model.Directions;
import com.twilightCarnival.model.InputValidator;
import java.io.IOException;
import java.util.Scanner;

public class StartGame {

  private final String clown = "       ,            _..._            ,\n"
      + "      {'.         .'     '.         .'}\n"
      + "     { ~ '.      _|=    __|_      .'  ~}\n"
      + "    { ~  ~ '-._ (___________) _.-'~  ~  }\n"
      + "   {~  ~  ~   ~.'           '. ~    ~    }\n"
      + "  {  ~   ~  ~ /   /\\     /\\   \\   ~    ~  }\n"
      + "  {   ~   ~  /    __     __    \\ ~   ~    }\n"
      + "   {   ~  /\\/  -<( o)   ( o)>-  \\/\\ ~   ~}\n"
      + "    { ~   ;(      \\/ .-. \\/      );   ~ }\n"
      + "     { ~ ~\\_  ()  ^ (   ) ^  ()  _/ ~  }\n"
      + "      '-._~ \\   (`-._'-'_.-')   / ~_.-'\n"
      + "          '--\\   `'._'\"'_.'`   /--'\n"
      + "              \\     \\`-'/     /\n"
      + "               `\\    '-'    /'\n"
      + "                 `\\       /'\n"
      + "                   '-...-'\n"
      + "------------------------------------------------";
//      + "Thank you for visiting https://asciiart.website/\n"
//      + "This ASCII pic can be found at\n"
//      + "https://asciiart.website/index.php?art=people/occupations/clowns\n";


  private final String titleCard1 = "\n \u001B[32m"
      + " ,ggggggggggggggg                                                             ,gggg,                                                                            \n"
      + "dP\"\"\"\"\"\"88\"\"\"\"\"\"\"               ,dPYb,                   ,dPYb,      I8     ,88\"\"\"Y8b,                                                                    ,dPYb,\n"
      + "Yb,_    88                      IP'`Yb                   IP'`Yb      I8    d8\"     `Y8                                                                    IP'`Yb\n"
      + " `\"\"    88                 gg   I8  8I  gg               I8  8I   88888888d8'   8b  d8                                      gg                            I8  8I\n"
      + "        88                 \"\"   I8  8'  \"\"               I8  8'      I8  ,8I    \"Y88P'                                      \"\"                            I8  8'\n"
      + "        88 gg    gg    gg  gg   I8 dP   gg     ,gggg,gg  I8 dPgg,    I8  I8'            ,gggg,gg   ,gggggg,   ,ggg,,ggg,    gg      ggg    gg   ,gggg,gg  I8 dP \n"
      + "        88 I8    I8    88bg88   I8dP    88    dP\"  \"Y8I  I8dP\" \"8I   I8  d8            dP\"  \"Y8I   dP\"\"\"\"8I  ,8\" \"8P\" \"8,   88     d8\"Yb   88bgdP\"  \"Y8I  I8dP  \n"
      + "  gg,   88 I8    I8    8I  88   I8P     88   i8'    ,8I  I8P    I8  ,I8, Y8,          i8'    ,8I  ,8'    8I  I8   8I   8I   88    dP  I8   8I i8'    ,8I  I8P   \n"
      + "   \"Yb,,8P,d8,  ,d8,  ,8I_,88,_,d8b,_ _,88,_,d8,   ,d8I ,d8     I8,,d88b,`Yba,,_____,,d8,   ,d8b,,dP     Y8,,dP   8I   Yb,_,88,_,dP   I8, ,8I,d8,   ,d8b,,d8b,_ \n"
      + "     \"Y8P'P\"\"Y88P\"\"Y88P\" 8P\"\"Y88P'\"Y888P\"\"Y8P\"Y8888P\"88888P     `Y88P\"\"Y8  `\"Y8888888P\"Y8888P\"`Y88P      `Y88P'   8I   `Y88P\"\"Y88\"     \"Y8P\" P\"Y8888P\"`Y88P'\"Y88\n"
      + "                                                   ,d8I'                                                                                                        \n"
      + "                                                 ,dP'8I                                                                                                         \n"
      + "                                                ,8\"  8I                                                                                                         \n"
      + "                                                I8   8I                                                                                                         \n"
      + "                                                `8, ,8I                                                                                                         \n"
      + "                                                 `Y8P\"                                                                                                          \n \u001B[0m";

  private Game game = new Game();

  /**
   * start() starts the game, with splash screen and following method to begin the logic.
   */
  public void start(){
    System.out.println(titleCard1);
    System.out.println(clown);
    game.display();
    System.out.println("\nPress the \"Enter\" key to continue.");
    Scanner input = new Scanner(System.in);
    input.nextLine();
    System.out.print("\033[H\033[2J");
    System.out.flush();
    game.status();
    userInput();

    // TODO: 12/14/2022 Put try again in a separate method?
//    if(){
//      game.status();
//      userInput();
//      System.out.println("Do you want to play again? (y/n)");
//      input = new Scanner(System.in);
//      if(input.nextLine().equalsIgnoreCase("y")){
//        game.playAgain();
//      }
//
//    }else{
//      System.out.println("Are you sure?(y/n)");
//      input = new Scanner(System.in);
//      if(input.nextLine().equals("y")){
//        game.quit();
//      }else{
//        game.playAgain();
//      }
//    }
  }


  /**
   * userInput is the main loop to handle user input from 'help', 'quit', and input commands like
   * 'go north'
   */
  private void userInput(){
    InputValidator validator = new InputValidator();
    String[] validInput = new String[2];
    Scanner input = new Scanner(System.in);
    String userChoice = "";
    while (true){
      userChoice = input.nextLine();
      if (userChoice.equals("")){
        System.out.println("Please enter a command.");
      } else if (userChoice.equalsIgnoreCase("help")) {
        game.help();
      } else if (userChoice.equalsIgnoreCase("quit")) {
        System.out.println("Are you sure you want to quit?(y/n)");
        if(input.nextLine().equals("y")) {
          game.quit();
          }
        else {
          System.out.println("Thanks for staying with us! Please enter a command to continue");
        }

      } else if (validator.isValid(userChoice)) {

        validInput = validator.getInput();
        operation(validInput[0], validInput[1]);
        //game.status();
        continue;
      }

    }
  }

  /**
   * operation handles the logic of valid input and carries out desired action.
   * @param verb is a filtered verb handled by InputValidator.isValid()
   * @param noun filtered noun handled by InputValidator.isValid()
   */
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
