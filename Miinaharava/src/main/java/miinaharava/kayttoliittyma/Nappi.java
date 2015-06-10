/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava.kayttoliittyma;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 * Luokka luo graafisessa käyttöliittymässä luotavan JButtoneista
 * koostuvan ruudukon osat.
 * 
 * @author ekorri
 */
public class Nappi extends JButton implements MouseListener{
    
    private int x;
    private int y;
    private Kayttoliittyma kayttoliittyma;
    
    public Nappi(int x, int y, Kayttoliittyma kayttoliittyma) {
        addMouseListener(this);
        this.x = x;
        this.y = y;
        this.kayttoliittyma = kayttoliittyma;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == 1) {
            kayttoliittyma.klikkaaRuutua(x, y);
        }
        if (e.getButton() == 3) {
            kayttoliittyma.klikkaaRuutuaOikealla(x, y);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
