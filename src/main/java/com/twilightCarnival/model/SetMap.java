package com.twilightCarnival.model;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
      String fileName = "json/locationInfo.json";
      Gson gson = new Gson();
      InputStream inputStream = getFileFromResources(fileName);
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
      stations = gson.fromJson(reader, new TypeToken<List<Station>>() {}.getType());

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Station> getStations() {
    return stations;
  }

  /**
   * get inputStream so json can work
   * @param fileName the file path in resources folder
   * @return InputStream
   */
  private static InputStream getFileFromResources(String fileName){
    ClassLoader classLoader = SetMap.class.getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream(fileName);
    if (inputStream == null){
      throw new IllegalArgumentException("file not found: " + fileName);
    } else {
      return inputStream;
    }
  }
}
