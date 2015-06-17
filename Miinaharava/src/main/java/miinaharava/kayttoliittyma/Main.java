

package miinaharava.kayttoliittyma;
import javax.swing.SwingUtilities;
import miinaharava.kayttoliittyma.Tekstikayttoliittyma;



public class Main {
    public static void main(String[] args) {
//        Peli peli = new Peli();
//        peli.run();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
