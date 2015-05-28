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
    public void avaaRuutuJossaEiMiinaaToimiiOikein() {
        pelilauta.getRuutu(5, 5).setOnkoRuudussaMiina(false);
        pelilauta.getRuutu(5, 4).setOnkoRuudussaMiina(true);
        pelilauta.getRuutu(5, 6).setOnkoRuudussaMiina(true);
        pelilauta.avaaRuutu(5, 5);
        
        
        assertEquals(2, pelilauta.getYmparillaOlevienMiinojenMaara(5, 5));
    }
    
    @Test
    public void avaaRuutuJossaEiMiinaaYmparillakaanToimiiOikein() {
        pelilauta.getRuutu(0, 0).setOnkoRuudussaMiina(false);
        pelilauta.getRuutu(1, 0).setOnkoRuudussaMiina(false);
        pelilauta.getRuutu(1, 1).setOnkoRuudussaMiina(false);
        pelilauta.getRuutu(0, 1).setOnkoRuudussaMiina(false);
        pelilauta.avaaRuutu(0, 0);
        
        assertEquals(true, pelilauta.getRuutu(1, 1).isAvattu());
    }
    
    @Test
    public void avaaRuutuJossaMiinaToimiiOikein() {
        pelilauta.getRuutu(5, 4).setOnkoRuudussaMiina(true);
        pelilauta.avaaRuutu(5, 4);
        
        assertEquals("*", pelilauta.getRuutu(5, 4).getTesti());
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
        pelilauta.avaaYmparillaOlevat2(8, 0);
        
        assertEquals(true, pelilauta.getRuutu(7, 0).isAvattu());
        
    }
    
    @Test
    public void avaaYmparillaOlevatToimiiOikein2() {
        pelilauta.getRuutu(5, 5).setAvattu(true);
        pelilauta.getRuutu(5, 5).setOnkoRuudussaMiina(false);
        pelilauta.avaaYmparillaOlevat2(5, 5);
        
        assertEquals(true, pelilauta.getRuutu(5, 4).isAvattu());
    }
    
    @Test
    public void avaaYmparillaOlevatToimiiOikein3() {
        pelilauta.getRuutu(5, 6).setAvattu(true);
        pelilauta.getRuutu(5, 6).setOnkoRuudussaMiina(false);
        pelilauta.getRuutu(5, 4).setOnkoRuudussaMiina(false);
        pelilauta.avaaYmparillaOlevat2(5, 6);
        
        assertEquals(true, pelilauta.getRuutu(5, 3).isAvattu());
    }
    
    @Test
    public void liputaRuutuToimiiOikein() {
        pelilauta.getRuutu(5, 5).setOnkoLiputettu(true);
        
        assertEquals(true, pelilauta.getRuutu(5, 5).isOnkoLiputettu());
    }
    
    @Test
    public void liputaRuutuToimiiOikein2() {
        pelilauta.getRuutu(6, 5).setOnkoLiputettu(true);
        
        assertEquals(true, pelilauta.getRuutu(6, 5).isOnkoLiputettu());
    }
    
    
    
}
