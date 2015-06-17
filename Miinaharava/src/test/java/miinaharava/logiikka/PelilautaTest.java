package miinaharava.logiikka;



import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import miinaharava.logiikka.Pelilauta;

/**
 *
 * @author ekorri
 */
public class PelilautaTest {
    
    Pelilauta pelilauta;
    
    public PelilautaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelilauta = new Pelilauta(9, 9, 10);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaLeveydenOikein() {
        assertEquals(9, pelilauta.getLeveys());
    }
    
    @Test
    public void konstruktoriAsettaaKorkeudenOikein() {
        assertEquals(9, pelilauta.getKorkeus());
    }
    
    @Test
    public void konstruktoriAsettaaMiinojenMaaranOikein() {
        assertEquals(10, pelilauta.getMiinoja());
    }
    
    @Test
    public void konstruktoriAsettaaLippujenMaaranOikein() {
        assertEquals(10, pelilauta.getLippuja());
    }
    
    @Test
    public void avaaRuutuJossaEiMiinaaToimiiOikein() {
        pelilauta.getRuutu(5, 5).setOnkoRuudussaMiina(false);
        pelilauta.getRuutu(5, 4).setOnkoRuudussaMiina(true);
        pelilauta.getRuutu(5, 6).setOnkoRuudussaMiina(true);
        pelilauta.avaaRuutu(5, 5);
        
        
        assertEquals(2, pelilauta.getYmparillaOlevienMiinojenMaara(5, 5));
    }
    
    @Test
    public void avaaRuutuJossaEiMiinaaToimiiOikein2() {
        pelilauta.getRuutu(5, 5).setOnkoRuudussaMiina(false);
        pelilauta.getRuutu(5, 4).setOnkoRuudussaMiina(true);
        pelilauta.getRuutu(5, 6).setOnkoRuudussaMiina(true);
        pelilauta.avaaRuutu(5, 5);
        
        assertEquals("2", pelilauta.getRuutu(5, 5).getArvo());
    }
    
    @Test
    public void avaaRuutuJossaEiMiinaaYmparillakaanToimiiOikein() {
        pelilauta.getRuutu(0, 0).setOnkoRuudussaMiina(false);
        pelilauta.getRuutu(1, 0).setOnkoRuudussaMiina(false);
        pelilauta.getRuutu(1, 1).setOnkoRuudussaMiina(false);
        pelilauta.getRuutu(0, 1).setOnkoRuudussaMiina(false);
        pelilauta.avaaRuutu(0, 0);
        
        assertEquals(true, pelilauta.getRuutu(1, 1).avattu());
    }
    
    @Test
    public void avaaRuutuJossaMiinaToimiiOikein() {
        pelilauta.getRuutu(5, 6).setOnkoRuudussaMiina(true);
        pelilauta.avaaRuutu(5, 6);
        
        assertEquals("*", pelilauta.getRuutu(5, 6).getArvo());
    }
    
    @Test
    public void avaaRuutuJossaLippuToimiiOikein() {
        pelilauta.getRuutu(3, 5).setOnkoLiputettu(true);
        pelilauta.avaaRuutu(3, 5);
        
        assertEquals(false, pelilauta.getRuutu(3, 5).onkoLiputettu());
    }
    
    @Test
    public void avaaRuutuJossaLippuToimiiOikein2() {
        pelilauta.getRuutu(1, 7).setOnkoLiputettu(true);
        pelilauta.avaaRuutu(1, 7);
        
        assertEquals(" ", pelilauta.getRuutu(1, 7).getArvo());
    }
    
    @Test
    public void getYmparillaOlevienMiinojenMaaraToimiiOikein() {
        pelilauta.getRuutu(5, 5).setOnkoRuudussaMiina(true);
        pelilauta.getRuutu(5, 4).setOnkoRuudussaMiina(true);
        
        assertEquals(2, pelilauta.getYmparillaOlevienMiinojenMaara(4, 5));
        
    }
    
    @Test
    public void avaaYmparillaOlevatToimiiOikein() {
        pelilauta.getRuutu(8, 0).setAvattu(true);
        pelilauta.getRuutu(8, 0).setOnkoRuudussaMiina(false);
        pelilauta.avaaYmparillaOlevat(8, 0);
        
        assertEquals(true, pelilauta.getRuutu(7, 0).avattu());
        
    }
    
    @Test
    public void avaaYmparillaOlevatToimiiOikein2() {
        pelilauta.getRuutu(5, 5).setAvattu(true);
        pelilauta.getRuutu(5, 5).setOnkoRuudussaMiina(false);
        pelilauta.avaaYmparillaOlevat(5, 5);
        
        assertEquals(true, pelilauta.getRuutu(5, 4).avattu());
    }
    
    @Test
    public void avaaYmparillaOlevatToimiiOikein3() {
        pelilauta.getRuutu(5, 6).setAvattu(true);
        pelilauta.getRuutu(5, 6).setOnkoRuudussaMiina(false);
        pelilauta.getRuutu(5, 4).setOnkoRuudussaMiina(false);
        pelilauta.avaaYmparillaOlevat(5, 6);
        
        assertEquals(true, pelilauta.getRuutu(5, 3).avattu());
    }
    
    @Test
    public void liputaRuutuToimiiOikein() {
        pelilauta.liputaRuutu(5, 5);
        
        assertEquals(true, pelilauta.getRuutu(5, 5).onkoLiputettu());
    }
    
    @Test
    public void liputaRuutuToimiiOikein2() {
        pelilauta.liputaRuutu(6, 5);
        
        assertEquals(true, pelilauta.getRuutu(6, 5).onkoLiputettu());
    }
    
    @Test
    public void liputaRuutuToimiiOikein3() {
        pelilauta.getRuutu(3, 5).setAvattu(true);
        pelilauta.liputaRuutu(3, 5);
        
        assertEquals(false, pelilauta.getRuutu(3, 5).onkoLiputettu());
    }
    
    @Test
    public void liputaRuutuArvoToimiiOikein() {      
        pelilauta.liputaRuutu(4, 4);
        
        assertEquals("P", pelilauta.getRuutu(4, 4).getArvo());
    }
    
    @Test
    public void liputaRuutuLippujenLkmToimiiOikein() {
        pelilauta.liputaRuutu(5, 1);
        pelilauta.liputaRuutu(2, 2);
        
        assertEquals(8, pelilauta.getLippuja());
    }
    
    @Test
    public void liputaRuutuLippujenLkmToimiiOikein2() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pelilauta.liputaRuutu(i, j);
            }
        }
        pelilauta.liputaRuutu(8, 8);
        pelilauta.liputaRuutu(7, 7);
        assertEquals(0, pelilauta.getLippuja());
    }
    
    @Test
    public void poistaLippuToimiiOikein() {
        pelilauta.liputaRuutu(5, 4);
        pelilauta.poistaLippu(5, 4);
        
        assertEquals(false, pelilauta.getRuutu(5, 4).onkoLiputettu());
    }
    
    @Test
    public void poistaLippuToimiiOikein2() {
        pelilauta.liputaRuutu(7, 6);
        pelilauta.poistaLippu(7, 6);
        
        assertEquals("[ ]", pelilauta.getRuutu(7, 6).getArvo());
    }
    
    @Test
    public void poistaLippuToimiiOikein3() {
        pelilauta.getRuutu(2, 8).setOnkoLiputettu(true);
        pelilauta.getRuutu(2, 8).setAvattu(true);        
        pelilauta.poistaLippu(2, 8);
        
        assertEquals(" ", pelilauta.getRuutu(2, 8).getArvo());
    }
    
    @Test
    public void poistaLippuLippujenLkmToimiiOikein() {
        pelilauta.liputaRuutu(5, 5);
        pelilauta.liputaRuutu(5, 6);
        pelilauta.liputaRuutu(0, 2);
        pelilauta.poistaLippu(5, 5);
        
        assertEquals(8, pelilauta.getLippuja());
    }
    
    @Test
    public void poistaLippuLippujenLkmToimiiOikein2() {
        pelilauta.liputaRuutu(2, 2);
        pelilauta.poistaLippu(2, 2);
        pelilauta.poistaLippu(2, 3);
        
        assertEquals(10, pelilauta.getLippuja());
    }
    
    @Test
    public void merkitseNumeroToimiiOikein() {
        pelilauta.getRuutu(4, 5).setOnkoRuudussaMiina(true);
        pelilauta.getRuutu(5, 5).setOnkoRuudussaMiina(true);
        pelilauta.merkitseNumero(4, 4);
        
        assertEquals("2", pelilauta.getRuutu(4, 4).getArvo());
    }
    
    @Test
    public void merkitseNumeroToimiiOikein2() {
        pelilauta.merkitseNumero(3, 2);
        
        assertEquals(" ", pelilauta.getRuutu(3, 2).getArvo());
    }
    
    @Test
    public void onkoKaikkiAvattuToimiiOikein() {
        pelilauta.asetaMiinat();
        for (int i = 0; i < pelilauta.getKorkeus(); i++) {
            for (int j = 0; j < pelilauta.getLeveys(); j++) {
                if (pelilauta.getRuutu(j, i).onkoRuudussaMiina() == false) {
                    pelilauta.getRuutu(j, i).setAvattu(true);
                }
            }
        }
        
        assertEquals(true, pelilauta.onkoKaikkiAvattu());
    }
    
    @Test
    public void onkoKaikkiAvattuToimiiOikein2() {
        pelilauta.asetaMiinat();
        for (int i = 0; i < pelilauta.getKorkeus() - 2; i++) {
            for (int j = 0; j < pelilauta.getLeveys() - 2; j++) {
                if (pelilauta.getRuutu(j, i).onkoRuudussaMiina() == false) {
                    pelilauta.getRuutu(j, i).setAvattu(true);
                }
            }
        }
        
        assertEquals(false, pelilauta.onkoKaikkiAvattu());
    }
    
    @Test
    public void naytaMiinatToimiiOikein() {
        pelilauta.getRuutu(4, 4).setOnkoRuudussaMiina(true);
        pelilauta.naytaMiinat();
        
        assertEquals("*", pelilauta.getRuutu(4, 4).getArvo());
    }
    
    @Test
    public void onkoMiinoitettuRuutuAvattuToimiiOikein() {
        pelilauta.getRuutu(6, 3).setOnkoRuudussaMiina(true);
        pelilauta.getRuutu(6, 3).setAvattu(true);
        
        assertEquals(true, pelilauta.onkoMiinoitettuRuutuAvattu());
    }
    
    @Test
    public void onkoMiinoitettuRuutuAvattuToimiiOikein2() {
        pelilauta.getRuutu(2, 6).setOnkoRuudussaMiina(true);
        pelilauta.getRuutu(2, 6).setAvattu(false);
        
        assertEquals(false, pelilauta.onkoMiinoitettuRuutuAvattu());
    }
    
    @Test
    public void onkoMiinoitettuRuutuAvattuToimiiOikein3() {
        pelilauta.getRuutu(4, 7).setOnkoRuudussaMiina(false);
        pelilauta.getRuutu(4, 7).setAvattu(true);
        
        assertEquals(false, pelilauta.onkoMiinoitettuRuutuAvattu());
    }
    
}
