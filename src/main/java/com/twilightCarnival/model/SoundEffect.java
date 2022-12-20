package com.twilightCarnival.model;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public enum SoundEffect {
  EARNEDKEY("audio/earnAKey.wav"),
  UNLOCK("audio/door-unlocking-with-keys.wav"),
  MONSTERGROWL("audio/enterMonsterRoom.wav"),
  OPENMAP("audio/openMap.wav"),
  PICKUP("audio/pickupFX.wav"),
  BACKGROUND("audio/Some-Dreamy-Place.wav")
  ;

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

  public void play(){
//    if (volume != Volume.OFF) {
      //volume = Volume.ON;
      soundClip.start();     // Start playing

//    }



  }

  public void stop() //stop playing and rewind to be played again from the beginning
  {
//    if (volume == Volume.OFF) {
    volume = Volume.OFF;
    soundClip.stop();
    soundClip.close();
    soundClip.setFramePosition(0);
//  }
  }

  public static void mute() //don't play sounds(Mute Sound is selected from Options menu)
  {
    volume = Volume.OFF;


  }
}
