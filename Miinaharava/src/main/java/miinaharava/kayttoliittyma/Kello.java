/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 * Tämä luokka luo kellon, joka mittaa pelaajan peliin käyttämää aikaa. Kello
 * käynnistyy ensimmäisestä klikkauksesta ja pysähtyy pelin loppuessa.
 * 
 * @author Eevastiina Korri
 */
public class Kello extends JLabel{
    private final static long STEPS = 1000; 
    private int seconds = -1;
    private int minutes = 0;
    private Timer timer;
  
    public Kello() {
        setHorizontalAlignment(JLabel.CENTER);
        setText("" + 0);
    }
    
    /**
     * Metodi panee kellon päälle.
     */
    public void start() {
        timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    if(minutes > 60){
                        setText("Elämä menee ohi...");
                    } else {
                        if(seconds > 60){
                            minutes++;
                            seconds = 0;
                        } else {
                            seconds++;                       
                        }
                        if(seconds > 10){
                            setText(String.valueOf(minutes) + ":" + String.valueOf(seconds));  
                        } else {
                            setText(String.valueOf(minutes) + ":" + "0" + String.valueOf(seconds));
                        }                     
                    }

                }
            };
        timer.scheduleAtFixedRate(task, 0, STEPS);
    }
    
    /**
     * Metodi pysäyttää kellon.
     */
    public void stop() {
        timer.cancel();
    }
  
}
