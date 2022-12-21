package com.twilightCarnival.model;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public enum SoundEffect {
  SOUNDEFFECT("audio/winning.wav");


  public enum Volume {
    OFF,
    ON
  }

  public static Volume volume = Volume.ON;

  private Clip soundClip;

  SoundEffect(String soundFile) {
    try {
      URL url = Music.class.getClassLoader().getResource(soundFile);
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
      soundClip = AudioSystem.getClip();
      soundClip.open(audioInput);


    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void play(String soundFile){
    volume = Volume.ON;
    try {
      URL url = Music.class.getClassLoader().getResource(soundFile);
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
      soundClip = AudioSystem.getClip();
      soundClip.open(audioInput);
      soundClip.start();

    } catch (Exception ex) {
      ex.printStackTrace();
    }



  }

  public void stop()
  {
    volume = Volume.OFF;
    soundClip.stop();
    soundClip.close();
    soundClip.setFramePosition(0);

  }

  public static void mute()
  {
    volume = Volume.OFF;


  }

  public static void unmute()
  {
    volume = Volume.ON;


  }



}
