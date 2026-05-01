package org.crypto;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    public static void playScream(){
        try{
            File soundFile=new File("src/main/resources/scream.wav");
            AudioInputStream audioStream= AudioSystem.getAudioInputStream(soundFile);
            Clip clip=AudioSystem.getClip();
            clip.open(audioStream);

            System.out.println("Scream sound initiated! Playing Scream");
            long duration=clip.getMicrosecondLength()/1000;
            Thread.sleep(duration);

        }catch(UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println("Could not play sound " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
