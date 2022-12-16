package com.twilightCarnival.model;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    try{ // TODO: 12/15/2022 read in file with inputstream? like getResourceAsStream()???
      String fileName = "json/script.json";
      Gson gson = new Gson();
      InputStream inputStream = getFileFromResources(fileName);
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
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

  private static InputStream getFileFromResources(String fileName){
    ClassLoader classLoader = Script.class.getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream(fileName);
    if (inputStream == null){
      throw new IllegalArgumentException("file not found: " + fileName);
    } else {
      return inputStream;
    }
  }
}
