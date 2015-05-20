package miinaharava.logiikka;



import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import miinaharava.logiikka.Ruutu;

/**
 *
 * @author ekorri
 */
public class RuutuTest {
    
    Ruutu ruutu;
    
    public RuutuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ruutu = new Ruutu(2);
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void konstruktoriToimiiOikeinTesti() {
        assertEquals("2", ruutu.toString());
    }
    
    @Test
    public void konstruktoriToimiiOikeinAvattu() {
        ruutu.setAvattu(true);
        
        assertEquals(true, ruutu.isAvattu());
    }
    
    @Test
    public void konstruktoriToimiiOikeinOnkoRuudussaMiina() {
        ruutu.setOnkoRuudussaMiina(true);
        
        assertEquals(true, ruutu.isOnkoRuudussaMiina());
    }
    
    @Test
    public void konstruktoriToimiiOikeinOnkoLiputettu() {
        ruutu.setOnkoLiputettu(true);
        
        assertEquals(true, ruutu.isOnkoLiputettu());
    }
    
    
}
