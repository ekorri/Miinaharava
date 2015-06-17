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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import miinaharava.logiikka.Pelilauta;

/**
 * Luokka luo Miinaharava-pelin graafisen käyttöliittymän.
 *
 * @author Eevastiina Korri
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Nappi[][] ruudukko = new Nappi[9][9];
    private Pelilauta lauta;
    private JLabel tekstikenttaAlaVasen;
    private JLabel tekstikenttaYla;
    private Kello kello;
    private boolean peliAlkanut = false;

    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(500, 550));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.lauta = new Pelilauta(9, 9, 10);
        this.lauta.asetaMiinat();

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Metodi lisää graafisen pelilaudan komponentit laudalle.
     *
     * @param container pelilaudan raamit, joiden sisään komponentit sijoitellaan
     */
    private void luoKomponentit(Container container) {
        container.add(luoTekstikenttaAla(), BorderLayout.SOUTH);
        container.add(luoRuudukko());
        container.add(luoTekstikenttaYla(), BorderLayout.NORTH);
    }

    /**
     * Metodi luo napeista koostuvan ruudukon pelilaudalle.
     *
     * @return palauttaa komponentin panel, joka sisältää ruudukon
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
     * klikkaamisesta hiiren vasemmalla nappulalla.
     *
     * @param x käsiteltävän ruudun x-koordinaatti
     * @param y käsiteltävän ruudun y-koordinaatti
     */
    public void klikkaaRuutua(int x, int y) {
        if (!peliAlkanut) {
            kello.start();
            peliAlkanut = true;
        }
        lauta.avaaRuutu(x, y);
        paivitaNapit();
    }

    /**
     * Metodi päivittää pelilaudan napit sen mukaan, mitä pelilaudalla on
     * tapahtunut.
     */
    public void paivitaNapit() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (lauta.getRuutu(j, i).getArvo() == "P") {
                    ruudukko[i][j].asetaLippu();
                    lauta.getRuutu(j, i).setArvo(" ");
                }
                if (lauta.getRuutu(j, i).getArvo() == "*") {
                    ruudukko[i][j].asetaMiina();
                    lauta.getRuutu(j, i).setArvo(" ");
                }
                ruudukko[i][j].setText(lauta.getRuutu(j, i).getArvo());

                if (this.pelinLoppu() == 1 && lauta.getRuutu(j, i).onkoRuudussaMiina() == false && lauta.getRuutu(j, i).onkoLiputettu()) {
                    ruudukko[i][j].setBackground(Color.red);
                }
            }
        }
    }

    /**
     * Metodi suorittaa toiminnallisuuden, joka seuraa tietyn ruudun
     * klikkaamisesta hiiren oikealla nappulalla.
     *
     * @param x käsiteltävän ruudun x-koordinaatti
     * @param y käsiteltävän ruudun y-koordinaatti
     */
    public void klikkaaRuutuaOikealla(int x, int y) {
        if (lauta.getRuutu(x, y).onkoLiputettu()) {
            lauta.poistaLippu(x, y);
            ruudukko[y][x].poistaLipunKuva();
        } else {
            lauta.liputaRuutu(x, y);
        }
        paivitaNapit();
    }

    /**
     * Metodi tarkistaa on peli lopussa.
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
     * Metodi luo uuden tekstikentän pelilaudan ruudukon alapuolelle.
     *
     * @return palauttaa tekstikentän sisältöineen
     */
    private JPanel luoTekstikenttaAla() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        tekstikenttaAlaVasen = new JLabel(" ");
        kello = new Kello();
        panel.add(tekstikenttaAlaVasen);
        panel.add(kello);
        return panel;
    }

    /**
     * Metodi päivittää tekstikentän sisällön pelin lopussa sen mukaan, miten
     * pelaajan peli sujui.
     */
    public void paivitaTekstikenttaAla() {
        if (pelinLoppu() == 1) {
            tekstikenttaAlaVasen.setText("Boom! Pieleen meni!");
        }
        if (pelinLoppu() == 2) {
            tekstikenttaAlaVasen.setText("Jee! Pääsit läpi!");
        }
    }

    /**
     * Metodi luo tekstikentän pelilaudan ruudukon yläpuolelle. Tekstikentässä
     * näkyy kuinka paljon pelaajalla on vielä lippuja käytettävissään.
     *
     * @return tekstikenttä
     */
    public JLabel luoTekstikenttaYla() {
        tekstikenttaYla = new JLabel("Lippuja jäljellä: " + lauta.getLippuja());
        return tekstikenttaYla;
    }

    /**
     * Metodi päivittää pelilaudan ruudukon yläpuolella olevan tekstikentän
     * vastaamaan pelin tilannetta.
     */
    public void paivitaTekstikenttaYla() {
        tekstikenttaYla.setText("Lippuja jäljellä: " + lauta.getLippuja());
    }

    /**
     * Metodi pysäyttää pelikellon.
     *
     */
    public void pysaytaKello() {
        kello.stop();
    }
}
