package com.twilightCarnival.model;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SetMap {
  private List<Station> stations;

  public SetMap(){

  }
  public SetMap(List<Station> stations){
    this.stations = stations;
  }
  public void load(){

    try {
      String fileName = "locationInfo.json";
      Gson gson = new Gson();
      Reader reader = Files.newBufferedReader(Paths.get(fileName));
      stations = gson.fromJson(reader, new TypeToken<List<Station>>() {}.getType());

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Station> getStations() {
    return stations;
  }

//  public static void main(String[] args) {
//    SetMap map = new SetMap();
//    map.load();
//    for(Station s: map.getStations()){
//      System.out.println("Item: " + s.getItem());
//    }
//  }
}
