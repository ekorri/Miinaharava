/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Luokka luo graafisessa käyttöliittymässä luotavan koostuvan
 * ruudukon osat. Perii luokan JButton ja toteuttaa rajapinnan MouseListener.
 *
 * @author Eevastiina Korri
 */
public class Nappi extends JButton implements MouseListener {

    private int x;
    private int y;
    private Kayttoliittyma kayttoliittyma;
    
    private ImageIcon pommi;
    private ImageIcon lippu;
    
    /**
     * Konstruktori.
     * @param x napin x-koordinaatti
     * @param y napin y-koordinaatti
     * @param kayttoliittyma graafinen käyttöliittyma, jonka osa napeista
     * koostuva ruudukko on
     */
    public Nappi(int x, int y, Kayttoliittyma kayttoliittyma) {
        addMouseListener(this);
        this.x = x;
        this.y = y;
        this.kayttoliittyma = kayttoliittyma;
        
        try {
            pommi = new ImageIcon(ImageIO.read( ClassLoader.getSystemResource( "bomb.png" ) ));
            lippu = new ImageIcon(ImageIO.read( ClassLoader.getSystemResource( "flag.png" ) ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setHorizontalTextPosition(SwingConstants.CENTER);
    }
    
    /**
     * Metodi tarkistaa hiiren vasemman näppäimen klikkauksen yhteydessä, onko peli loppu ja päivittää
     * käyttöliittymän tekstikentän sen mukaan.
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (kayttoliittyma.pelinLoppu() == 1 || kayttoliittyma.pelinLoppu() == 2) {
            kayttoliittyma.paivitaTekstikenttaAla();
            kayttoliittyma.pysaytaKello();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Metodi määrittelee tapahtumat, jotka seuraavat hiiren vasemman ja oikean
     * näppäimen klikkauksesta.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == 1) {
            kayttoliittyma.klikkaaRuutua(x, y);
        }
        if (e.getButton() == 3) {
            kayttoliittyma.klikkaaRuutuaOikealla(x, y);
            kayttoliittyma.paivitaTekstikenttaYla();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    /**
     * Metodi asettaa lipun kuvan haluttuun kohteeseen.
     */
    public void asetaLippu() {
        setIcon(lippu);
    }
    
    /**
     * Metodi poistaa lipun kuvan kohteesta.
     */
    public void poistaLipunKuva() {
        setIcon(null);
    }
    
    /**
     * Metodi asettaa miinan kuvan haluttun kohteeseen.
     */
    public void asetaMiina() {
        setIcon(pommi);
    }
    
}
