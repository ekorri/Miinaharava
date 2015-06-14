/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
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
 * Luokka luo Miinaharava-pelin graafisen käyttöliittymän.
 *
 * @author Eevastiina Korri
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private JButton[][] ruudukko = new JButton[9][9];
    private Pelilauta lauta;
    private JLabel tekstikenttaAla;

    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(500, 550));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        this.lauta = new Pelilauta(9, 9, 10);
        this.lauta.asetaMiinat();

        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Metodi lisää graafisen pelilaudan komponentit laudalle
     * 
     * @param container pelilaudan raamit, joiden sisään komponenti sijoitellaan
     */
    private void luoKomponentit(Container container) {      
        container.add(luoTekstikentta(), BorderLayout.SOUTH);
        container.add(new JTextArea(), BorderLayout.NORTH);
        container.add(luoRuudukko());

    }
    
    /**
     * Metodi luo napeista koostuvan ruudukon pelilaudalle
     * 
     * @return palauttaa kompnentin panel, joka sisältää ruudukon
     */
    private JPanel luoRuudukko() {
        JPanel panel = new JPanel(new GridLayout(9, 9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                ruudukko[i][j] = new Nappi(j, i, this);
                panel.add(ruudukko[i][j]);
            }
        }
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
    
    /**
     * Metodi suorittaa toiminnallisuuden, joka seuraa tietyn ruudun
     * valitsemisesta hiirellä
     * 
     * @param x käsiteltävän ruudun x-koordinaatti
     * @param y käsiteltävän ruudun y-koordinaatti
     */
    public void klikkaaRuutua(int x, int y) {
        lauta.avaaRuutu(x, y);
        paivitaNapit();
    }
    
    /**
     * Metodi päivittää pelilaudan napit sen mukaan, mitä pelilaudalla on
     * tapahtunut
     */
    public void paivitaNapit() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                ruudukko[i][j].setText(lauta.getRuutu(j, i).getArvo());
//                if (lauta.getRuutu(j, i).getArvo() == "*") {
//                    ruudukko[i][j].setBackground(Color.red);
//                }
            }
        }
    }
     /**
      * Metodi suorittaa toiminnallisuuden, joka seuraa tietyn ruudun
      * klikkaamisesta hiiren oikealla näppäimellä
      * 
      * @param x käsitelvätän ruudun x-koordinaatti
      * @param y käsiteltävän ruudun y-koordinaatti
      */
    public void klikkaaRuutuaOikealla(int x, int y) {
        if (lauta.getRuutu(x, y).onkoLiputettu()) {
            lauta.poistaLippu(x, y);
        } else {
            lauta.liputaRuutu(x, y);
        }
        paivitaNapit();
    }
     /**
      * Metodi tarkistaa on peli lopussa
      * 
      * @return 1, jos pelaaja osui miinaan, 2, jos pelaaja sai pelin läpi
      */
    public int pelinLoppu() {
        if (lauta.onkoMiinoitettuRuutuAvattu()) {
            return 1;
        }
        if (lauta.onkoKaikkiAvattu()) {
            return 2;
        }
        return 0;
    }
    
    /**
     * Metodi luo uuden tekstikentän pelilaudan ruudukon alapuolelle
     * 
     * @return palauttaa tekstikentän sisältöineen 
     */
    private JLabel luoTekstikentta() {
        tekstikenttaAla = new JLabel(" ");
        return tekstikenttaAla;
    }
    
    /**
     * Metodi päivittää tekstikentän sisällön pelin lopussa sen mukaan,
     * miten pelaajan peli sujui
     */
    public void paivitaTekstikenttaAla() {
        if (pelinLoppu() == 1) {
            tekstikenttaAla.setText("Boom! Pieleen meni!");
        }
        if (pelinLoppu() == 2) {
            tekstikenttaAla.setText("Jee! Pääsit läpi!");
        }
    }
}
