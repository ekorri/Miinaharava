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
                ruudukko[i][j] = new Ruutu("X");
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

    public Ruutu getRuutu(int x, int y) {
        return ruudukko[y][x];
    }
    
    public void asetaMiinat() {
        int i = 0;
        while (i < this.miinoja) {
            Ruutu miinoitettava = ruudukko[random.nextInt(this.korkeus)][random.nextInt(this.leveys)];
            if (miinoitettava.isOnkoRuudussaMiina() == false) {
                miinoitettava.setOnkoRuudussaMiina(true);
                i++;
            }
            

        }
    }

    public void avaaRuutu(int x, int y) {
        if (x < 0 || x > this.leveys - 1 || y < 0 || y > this.korkeus - 1) {
            return;
        }
        if (ruudukko[y][x].isAvattu() == true) {
            return;
        }
        ruudukko[y][x].setAvattu(true);

        if (ruudukko[y][x].isOnkoRuudussaMiina() == false) {
            this.merkitseNumero(x, y);

        }
        if (ruudukko[y][x].isOnkoRuudussaMiina() == false && this.getYmparillaOlevienMiinojenMaara(x, y) == 0) {
            this.merkitseNumero(x, y);
            this.avaaYmparillaOlevat2(x, y);
        }

    }

    public void liputaRuutu(int x, int y) {
        ruudukko[y][x].setOnkoLiputettu(true);
        ruudukko[y][x].setTesti("P");
    }

    public int getYmparillaOlevienMiinojenMaara(int x, int y) {
        int alkuX = Math.max(0, x - 1);
        int alkuY = Math.max(0, y - 1);
        int loppuX = Math.min(x + 1, this.leveys - 1);
        int loppuY = Math.min(y + 1, this.korkeus - 1);
        int laskuri = 0;

        for (int yi = alkuY; yi <= loppuY; yi++) {
            for (int xi = alkuX; xi <= loppuX; xi++) {
                if (yi == y && xi == x) {
                    continue;
                }
                if (ruudukko[yi][xi].isOnkoRuudussaMiina() == true) {
                    laskuri++;
                }
            }
        }
        return laskuri;
    }
    
    public void merkitseNumero(int x, int y) {
        String numero = "" + this.getYmparillaOlevienMiinojenMaara(x, y);
        ruudukko[y][x].setTesti(numero);
    }

    public void avaaYmparillaOlevat2(int x, int y) {
        int alkuX = Math.max(0, x - 1);
        int alkuY = Math.max(0, y - 1);
        int loppuX = Math.min(x + 1, this.leveys - 1);
        int loppuY = Math.min(y + 1, this.korkeus - 1);

        for (int yi = alkuY; yi <= loppuY; yi++) {
            for (int xi = alkuX; xi <= loppuX; xi++) {
                if (ruudukko[yi][xi].isAvattu()) {
                    continue;
                }
                if (yi == y && xi == x) {
                    continue;
                }
                if (ruudukko[yi][xi].isOnkoRuudussaMiina() == false) {
                    ruudukko[yi][xi].setAvattu(true);
                    this.merkitseNumero(xi, yi);
                    if (this.getYmparillaOlevienMiinojenMaara(xi, yi) == 0) {
                        avaaYmparillaOlevat2(xi, yi);
                    }
                }
            }
        }
    }

    public boolean onkoKaikkiAvattu() {
        int kaikkiAvattu = this.korkeus * this.leveys - this.miinoja;
        int laskuri = 0;
        
        for (int i = 0; i < this.korkeus; i++) {
            for (int j = 0; j < this.leveys; j++) {
                if (ruudukko[i][j].isAvattu()) {
                    laskuri++;
                }
            }
        }
        if (kaikkiAvattu - laskuri == 0) {
            return true;
        } 
        return false;
    }
    
    public void naytaMiinat() {
        for (int i = 0; i < this.korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                if (ruudukko[i][j].isOnkoRuudussaMiina()) {
                    ruudukko[i][j].setTesti("*");
                } 
            }
        }
    }
}
