package com.twilightCarnival.model;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;



public class Music {

  private static Clip musicClip;


  public static void playMusic(String musicLocation) {
    try
    {
      File musicPath = new File(musicLocation);


      if(musicPath.exists())
      {

        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
        musicClip = AudioSystem.getClip();
        musicClip.open(audioInput);
        musicClip.start();
        //musicClip.loop(Clip.LOOP_CONTINUOUSLY);


      }
      else
      {
        System.out.println("Can't find music file");
      }
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }

  }


  public static void stopMusic() {
  musicClip.stop();
  musicClip.close();

  }

  public void volumeUp(){

  }
  public void volumeDown(){

  }

}
