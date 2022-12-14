package com.twilightCarnival.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SetMap {
  private SetMap map;
  private Station station;

  public void load(){
    try {
      // create Gson instance
      Gson gson = new Gson();

      // create a reader
      Reader reader = Files.newBufferedReader(Paths.get("locationInfo.json"));

      // convert JSON array to list of users
      List<Station> users = new Gson().fromJson(reader, new TypeToken<List<Station>>() {}.getType());

      // print users
      users.forEach(System.out::println);

      // close reader
      reader.close();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }



}
