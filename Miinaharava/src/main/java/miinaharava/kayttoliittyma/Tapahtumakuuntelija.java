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
 *
 * @author ekorri
 */
public class Tapahtumakuuntelija implements ActionListener {
    
    private JButton nappi;
    
    public Tapahtumakuuntelija(JButton nappi) {
        this.nappi = nappi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.nappi.setText("*");
    }
    
}
