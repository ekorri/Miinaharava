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
    
    
    
    
    
}
