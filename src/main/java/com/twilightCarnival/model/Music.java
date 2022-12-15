package com.twilightCarnival.model;


import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;


public class Music extends JFrame {


  public Music() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Test Sound Clip");
    this.setSize(300, 200);
    this.setVisible(true);

    try {
      // Open an audio input stream.
      URL url = this.getClass().getClassLoader().getResource("audio/new-music.wav");
      AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
      // Get a sound clip resource.
      Clip clip = AudioSystem.getClip();
      // Open audio clip and load samples from the audio input stream.
      clip.open(audioIn);
      clip.start();
    } catch (UnsupportedAudioFileException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (LineUnavailableException e) {
      e.printStackTrace();
    }

  }
  public void turnOn(){

  }
  public void turnOff(){

  }
  public void volumeUp(){

  }
  public void volumeDown(){
    
  }

public static void main(String[] args) {
  new Music();
}
}
