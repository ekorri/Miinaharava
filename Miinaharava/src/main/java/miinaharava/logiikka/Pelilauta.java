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
        for (int i = 0; i < this.miinoja; i++) {
            Miina miina = new Miina(random.nextInt(this.korkeus), random.nextInt(this.leveys));
            ruudukko[miina.getyKoordinaatti()][miina.getxKoordinaatti()].setOnkoRuudussaMiina(true);
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
        if (ruudukko[y][x].isOnkoRuudussaMiina() == true) {
            ruudukko[y][x].setTesti("*");
            return;
        }

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
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 0) {
            ruudukko[y][x].setTesti("0");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 1) {
            ruudukko[y][x].setTesti("1");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 2) {
            ruudukko[y][x].setTesti("2");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 3) {
            ruudukko[y][x].setTesti("3");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 4) {
            ruudukko[y][x].setTesti("4");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 5) {
            ruudukko[y][x].setTesti("5");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 6) {
            ruudukko[y][x].setTesti("6");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 7) {
            ruudukko[y][x].setTesti("7");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 8) {
            ruudukko[y][x].setTesti("8");
        }
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


}
