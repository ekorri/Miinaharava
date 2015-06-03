/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import miinaharava.logiikka.Pelilauta;

/**
 *
 * @author ekorri
 */
public class Kayttoliittyma implements Runnable{
    
    private JFrame frame;
    private JButton[][] ruudukko = new JButton[10][10];
    private Pelilauta lauta;

    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(500, 550));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        this.lauta = new Pelilauta(10, 10, 10);
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(new JTextArea(), BorderLayout.SOUTH);
        container.add(new JTextArea(), BorderLayout.NORTH);
        container.add(luoRuudukko());
        
    }
    
    private JPanel luoRuudukko() {
        JPanel panel = new JPanel(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ruudukko[i][j] = new Nappi(j, i, this);
                panel.add(ruudukko[i][j]);
            }
        }
        return panel;
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
}
