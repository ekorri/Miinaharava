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
 * @author ekorri
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

    private void luoKomponentit(Container container) {      
        container.add(luoTekstikentta(), BorderLayout.SOUTH);
        container.add(new JTextArea(), BorderLayout.NORTH);
        container.add(luoRuudukko());

    }

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

    public void klikkaaRuutua(int x, int y) {
        lauta.avaaRuutu(x, y);
        paivitaNapit();
    }

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

    public void klikkaaRuutuaOikealla(int x, int y) {
        if (lauta.getRuutu(x, y).onkoLiputettu()) {
            lauta.poistaLippu(x, y);
        } else {
            lauta.liputaRuutu(x, y);
        }
        paivitaNapit();
    }
    
    public int pelinLoppu() {
        if (lauta.onkoMiinoitettuRuutuAvattu()) {
            return 1;
        }
        if (lauta.onkoKaikkiAvattu()) {
            return 2;
        }
        return 0;
    }
    
    private JLabel luoTekstikentta() {
        tekstikenttaAla = new JLabel(" ");
        return tekstikenttaAla;
    }
    
    public void paivitaTekstikenttaAla() {
        if (pelinLoppu() == 1) {
            tekstikenttaAla.setText("Boom! Pieleen meni!");
        }
        if (pelinLoppu() == 2) {
            tekstikenttaAla.setText("Jee! Pääsit läpi!");
        }
    }
}
