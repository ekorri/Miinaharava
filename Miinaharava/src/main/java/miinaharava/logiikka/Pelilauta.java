package miinaharava.logiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 * Luokka luo pelin pelilaudan ja luokan metodit suorittavat pelilautaan
 * olennaisesti kuuluvan pelilogiikan, kuten ruutujen tilan tarkistuksen ja sen
 * muuttamisen.
 *
 * @author Eevastiina Korri
 */
public class Pelilauta {

    private int leveys;
    private int korkeus;
    private int miinoja;
    private Random random;
    private Ruutu[][] ruudukko;

    /**
     * Konstruktori
     *
     * Luo uuden pelilaudan
     *
     * @param leveys pelilaudan leveys ruutuina
     * @param korkeus pelilaudan korkeus ruutuina
     * @param miinoja miinojen määrä
     */
    public Pelilauta(int leveys, int korkeus, int miinoja) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.miinoja = miinoja;
        this.random = new Random();
        this.ruudukko = new Ruutu[this.korkeus][this.leveys];
        for (int i = 0; i < this.korkeus; i++) {
            for (int j = 0; j < this.leveys; j++) {
                ruudukko[i][j] = new Ruutu("[ ]");
            }
        }
    }

    /**
     * Metodi tulostaa pelilaudan ruudukon
     *
     */
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

    /**
     * Metodi arpoo miinojen paikat ja asettaa ne pelilaudalle
     */
    public void asetaMiinat() {
        int i = 0;
        while (i < this.miinoja) {
            Ruutu miinoitettava = ruudukko[random.nextInt(this.korkeus)][random.nextInt(this.leveys)];
            if (miinoitettava.onkoRuudussaMiina() == false) {
                miinoitettava.setOnkoRuudussaMiina(true);
                i++;
            }

        }
    }

    /**
     * Metodi asettaa ruudun avatuksi ja tarkistaa, onko mikä arvo ruudussa on;
     * kuinka monta miinaa ruudun lähellä on.
     *
     * @param x käsiteltävän ruudun x-koordinaatti
     * @param y käsiteltävän ruudun y-koordinaatti
     */
    public void avaaRuutu(int x, int y) {
        if (x < 0 || x > this.leveys - 1 || y < 0 || y > this.korkeus - 1) {
            return;
        }
        if (ruudukko[y][x].avattu() == true) {
            return;
        }
        ruudukko[y][x].setAvattu(true);

        if (ruudukko[y][x].onkoRuudussaMiina() == true) {
            this.naytaMiinat();
        }

        if (ruudukko[y][x].onkoRuudussaMiina() == false) {
            this.merkitseNumero(x, y);

        }
        if (ruudukko[y][x].onkoRuudussaMiina() == false && this.getYmparillaOlevienMiinojenMaara(x, y) == 0) {
            this.merkitseNumero(x, y);
            this.avaaYmparillaOlevat(x, y);
        }

    }

    /**
     * Metodi asettaa merkin ruutuun, jossa oletetaan olevan miina.
     *
     * @param x käsiteltävän ruudun x-koordinaatti
     * @param y käsiteltävän ruudun y-koordinaatti
     */
    public void liputaRuutu(int x, int y) {
        if (ruudukko[y][x].onkoLiputettu()) {
            return;
        }
        ruudukko[y][x].setOnkoLiputettu(true);
        ruudukko[y][x].setArvo("P");
    }
    
    /**
     * Metodi poistaa merkin ruudusta, jos siinä on sellainen
     * @param x
     * @param y 
     */
    public void poistaLippu(int x, int y) {
        if (ruudukko[y][x].onkoLiputettu() == false) {
            return;
        }        
        ruudukko[y][x].setOnkoLiputettu(false);
        ruudukko[y][x].setArvo("[ ]");
    }

    /**
     * Metodi laskee ruudun ympärillä olevien miinan sisältävien ruutujen
     * määrän.
     *
     * @param x käsiteltävän ruudun x-koordinaatti
     * @param y käsiteltävän ruudun y-koordinaatti
     * @return käsiteltävän ruudun ympärillä olevien miinan sisältävien ruutujen
     * määrä
     */
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
                if (ruudukko[yi][xi].onkoRuudussaMiina() == true) {
                    laskuri++;
                }
            }
        }
        return laskuri;
    }

    /**
     * Metodi merkitsee ruutuun numeron, joka vastaa siihen yhteydessä olevien
     * miinan sisältävien ruutujen määrää.
     *
     * @param x käsiteltävän ruudun x-koordinaatti
     * @param y käsiteltävän ruudun y-koordinaatti
     */
    public void merkitseNumero(int x, int y) {
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 0) {
            ruudukko[y][x].setArvo(" ");
        } else {
            String numero = "" + this.getYmparillaOlevienMiinojenMaara(x, y);
            ruudukko[y][x].setArvo(numero);
        }
    }

    /**
     * Metodi avaa kaikki käsiteltävään ruutuun yhteydessä olevat ruudut, jotka
     * eivät sisällä miinaa.
     *
     * @param x käsiteltävän ruudun x-koordinaatti
     * @param y käsiteltävän ruudun y-koordinaatti
     */
    public void avaaYmparillaOlevat(int x, int y) {
        int alkuX = Math.max(0, x - 1);
        int alkuY = Math.max(0, y - 1);
        int loppuX = Math.min(x + 1, this.leveys - 1);
        int loppuY = Math.min(y + 1, this.korkeus - 1);

        for (int yi = alkuY; yi <= loppuY; yi++) {
            for (int xi = alkuX; xi <= loppuX; xi++) {
                if (ruudukko[yi][xi].avattu()) {
                    continue;
                }
                if (yi == y && xi == x) {
                    continue;
                }
                if (ruudukko[yi][xi].onkoRuudussaMiina() == false) {
                    ruudukko[yi][xi].setAvattu(true);
                    this.merkitseNumero(xi, yi);
                    if (this.getYmparillaOlevienMiinojenMaara(xi, yi) == 0) {
                        avaaYmparillaOlevat(xi, yi);
                    }
                }
            }
        }
    }

    /**
     * Metodi tarkistaa, onko kaikki sellaiset ruudut, joissa ei ole miinaa,
     * avattu
     *
     * @return true tai false sen mukaan, onko kaikki ruudut avattu vai ei
     */
    public boolean onkoKaikkiAvattu() {
        int kaikkiAvattu = this.korkeus * this.leveys - this.miinoja;
        int laskuri = 0;

        for (int i = 0; i < this.korkeus; i++) {
            for (int j = 0; j < this.leveys; j++) {
                if (ruudukko[i][j].avattu()) {
                    laskuri++;
                }
            }
        }
        if (kaikkiAvattu - laskuri == 0) {
            return true;
        }
        return false;
    }

    /**
     * Metodi tulostaa ruudukkoon miinan symbolin kaikkiin niihin ruutuihin,
     * joissa on miina
     *
     */
    public void naytaMiinat() {
        for (int i = 0; i < this.korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                if (ruudukko[i][j].onkoRuudussaMiina()) {
                    ruudukko[i][j].setArvo("*");
                }
            }
        }
    }
    
    /**
     * Metodi tarkistaa, onko joku miinan sisältävä ruutu avattu.
     * 
     * @return true tai false sen mukaan onko miinallinen ruutu avattu vai ei
     */
    public boolean onkoMiinoitettuRuutuAvattu() {
        for (int i = 0; i < this.korkeus; i++) {
            for (int j = 0; j < this.leveys; j++) {
                if (ruudukko[i][j].onkoRuudussaMiina() && ruudukko[i][j].avattu()) {
                    return true;
                }
            }
        }
        return false;
    }
    
}
