package miinaharava.kayttoliittyma;

import java.util.Scanner;
import miinaharava.logiikka.Pelilauta;
import miinaharava.logiikka.Ruutu;

public class Peli {

    private Pelilauta lauta;
    private Scanner lukija;

    public Peli() {
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
                String vast = lukija.nextLine();
                if (vast.equals("avataan")) {
                    System.out.print("Anna y-koordinaatti: ");
                    int yKoordin = Integer.parseInt(lukija.nextLine());
                    System.out.print("Anna x-koordinaatti: ");
                    int xKoordin = Integer.parseInt(lukija.nextLine());
                    lauta.avaaRuutu(xKoordin, yKoordin);
                    Ruutu avattava = lauta.getRuutu(xKoordin, yKoordin);
                    if (avattava.isOnkoRuudussaMiina() == true) {
                        lauta.tulostaRuudukko();
                        System.out.println("Räjähdit, peli loppuu!");
                        break;
                    }

                }
                if (vast.equals("liputetaan")) {
                    System.out.print("Anna y-koordinaatti: ");
                    int yKoordin = Integer.parseInt(lukija.nextLine());
                    System.out.print("Anna x-koordinaatti: ");
                    int xKoordin = Integer.parseInt(lukija.nextLine());
                    lauta.liputaRuutu(xKoordin, yKoordin);
                }

            }
            if (vastaus.equals("en")) {
                break;
            }

        }
    }
}
