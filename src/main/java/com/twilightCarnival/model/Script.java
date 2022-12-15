package com.twilightCarnival.model;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Script {
  private Script script;
  private String introduction;
  private String directions;
  private String toolMessage;
  private String winMessage;
  private String help;
  private String playAgainMessage;

  public Script() {

  }

  public Script(String introduction, String directions, String toolMessage, String winMessage, String help, String playAgainMessage){
    this.introduction = introduction;
    this.directions = directions;
    this.toolMessage = toolMessage;
    this.winMessage = winMessage;
    this.help = help;
    this.playAgainMessage = playAgainMessage;
  }
  public void load(){
    try{
      String fileName = "script.json";
      Reader reader = Files.newBufferedReader(Paths.get(fileName));
      Gson gson = new Gson();
      script = gson.fromJson(reader, Script.class);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public String getIntroduction() {
    return introduction;
  }

  public String getDirections() {
    return directions;
  }

  public String getToolMessage() {
    return toolMessage;
  }

  public String getWinMessage() {
    return winMessage;
  }

  public String getHelp() {
    return help;
  }

  public String getPlayAgainMessage() {
    return playAgainMessage;
  }

  public Script getScript() {
    return script;
  }
}
