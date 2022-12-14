package com.twilightCarnival.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
      // create Gson instance
      Gson gson = new Gson();

      // create a reader
      Reader reader = Files.newBufferedReader(Paths.get("locationInfo.json"));

      // convert JSON array to list of users
       stations = new Gson().fromJson(reader, new TypeToken<List<Station>>() {}.getType());

      // print users
//      for(Station s: stations){
//        System.out.println(s);
//      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public List<Station> getStations() {
    return stations;
  }

  public static void main(String[] args) {
    SetMap map = new SetMap();
    map.load();

  }
}
