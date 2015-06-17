package miinaharava.kayttoliittyma;

import java.util.Scanner;
import miinaharava.logiikka.Pelilauta;
import miinaharava.logiikka.Ruutu;

/**
 * Luokka on tekstipohjainen käyttöliittymä Miinaharava-pelille.
 * 
 * @author Eevastiina Korri
 */
public class Tekstikayttoliittyma {

    private Pelilauta lauta;
    private Scanner lukija;

    public Tekstikayttoliittyma() {
        this.lauta = new Pelilauta(9, 9, 10);
        this.lukija = new Scanner(System.in);
    }

    public void run() {
        lauta.asetaMiinat();

        System.out.println("Aloitetaan peli");

        while (true) {

            lauta.tulostaRuudukko();
            System.out.print("Haluatko avata tai liputtaa ruudun? ");

            String vastaus = lukija.nextLine();
            if (vastaus.equals("kylla")) {
                System.out.print("Avataanko vai liputetaanko? ");
                String vastaus2 = lukija.nextLine();
                if (vastaus2.equals("avataan")) {
                    System.out.print("Anna y-koordinaatti: ");
                    int y = Integer.parseInt(lukija.nextLine());
                    System.out.print("Anna x-koordinaatti: ");
                    int x = Integer.parseInt(lukija.nextLine());
                    lauta.avaaRuutu(x, y);
                    Ruutu avattava = lauta.getRuutu(x, y);
                    if (avattava.onkoRuudussaMiina() == true) {
                        lauta.naytaMiinat();
                        lauta.tulostaRuudukko();
                        System.out.println("Räjähdit, peli loppuu!");
                        break;
                    }

                }
                if (vastaus2.equals("liputetaan")) {
                    System.out.print("Anna y-koordinaatti: ");
                    int y = Integer.parseInt(lukija.nextLine());
                    System.out.print("Anna x-koordinaatti: ");
                    int x = Integer.parseInt(lukija.nextLine());
                    lauta.liputaRuutu(x, y);
                }

            }
            if (vastaus.equals("en")) {
                break;
            }

        }
    }
}
