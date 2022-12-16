package com.twilightCarnival.model;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Music {

  public static void playMusic(String musicLocation) {
    try {
      URL url = Music.class.getClassLoader().getResource(musicLocation);
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
      Clip musicClip = AudioSystem.getClip();
      musicClip.open(audioInput);
      musicClip.start();
      //musicClip.loop(Clip.LOOP_CONTINUOUSLY);

    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }


  public void stopMusic() {

  }

  public void volumeUp() {

  }

  public void volumeDown() {

  }

}
