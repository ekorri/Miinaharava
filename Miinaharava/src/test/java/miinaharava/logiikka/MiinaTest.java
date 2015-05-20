package miinaharava.logiikka;


import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import miinaharava.logiikka.Miina;

public class MiinaTest {
    
    Miina miina;



    @Before
    public void setUp() {
        miina = new Miina(2, 3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaKoordinaatitOikein() {
        assertEquals("Koordinaatit: 2, 3", miina.toString());
    }
    
    @Test
    public void getxKoordinaattiToimiiOikein() {
        assertEquals(2, miina.getxKoordinaatti());
    }
    
    @Test
    public void getyKoordinaattiToimiiOikein() {
        assertEquals(3, miina.getyKoordinaatti());
    }
    
    @Test
    public void setxKoordinaattiToimiiOikein() {
        miina.setxKoordinaatti(3);
        
        assertEquals("Koordinaatit: 3, 3", miina.toString());
    }
    
    @Test
    public void setyKoordinaattiToimiiOikein() {
        miina.setyKoordinaatti(4);
        
        assertEquals("Koordinaatit: 2, 4", miina.toString());
    }

}
