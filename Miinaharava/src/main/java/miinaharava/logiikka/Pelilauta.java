package miinaharava.logiikka;

import java.util.ArrayList;
import java.util.Random;

public class Pelilauta {

    private int leveys;
    private int korkeus;
    private int miinoja;    
    private Random random;
    private Ruutu[][] ruudukko;

    public Pelilauta(int leveys, int korkeus, int miinoja) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.miinoja = miinoja;
        this.random = new Random();
        this.ruudukko = new Ruutu[this.korkeus][this.leveys];
        for (int i = 0; i < this.korkeus; i++) {
            for (int j = 0; j < this.leveys; j++) {                
                ruudukko[i][j] = new Ruutu(0);
            }
        }
    }   
        

    public void tulostaRuudukko() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                System.out.print(ruudukko[i][j]);
            }
            System.out.println("");
        }
    }
        
    

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getMiinoja() {
        return miinoja;
    }

    
    
    

    public void asetaMiinat() {
        for (int i = 0; i < this.miinoja; i++) {
            Miina miina = new Miina(random.nextInt(this.leveys), random.nextInt(this.korkeus));
        }
    }
}
