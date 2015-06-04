/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Luokka luo graafisessa käyttöliittymässä luotavan JButtoneista
 * koostuvan ruudukon osat.
 * 
 * @author ekorri
 */
public class Nappi extends JButton implements ActionListener{
    
    private int x;
    private int y;
    private Kayttoliittyma kayttoliittyma;
    
    public Nappi(int x, int y, Kayttoliittyma kayttoliittyma) {
        addActionListener(this);
        this.x = x;
        this.y = y;
        this.kayttoliittyma = kayttoliittyma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kayttoliittyma.klikkaaRuutua(x, y);
    }
    
}
